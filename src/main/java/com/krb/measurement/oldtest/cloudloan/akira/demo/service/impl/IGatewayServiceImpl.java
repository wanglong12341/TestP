package com.krb.measurement.oldtest.cloudloan.akira.demo.service.impl;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.krb.measurement.oldtest.cloudloan.akira.demo.service.IGatewayService;
import com.krb.measurement.oldtest.cloudloan.akira.demo.util.LoadUtils;
import com.krb.measurement.oldtest.cloudloan.akira.demo.util.RSA;
import com.krb.measurement.oldtest.cloudloan.akira.demo.properties.GatewayProperties;

import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * {@link IGatewayService} 实现
 *
 * @author cloudloan
 * @since 2019/10/24
 */
public class IGatewayServiceImpl implements IGatewayService {

    /**
     *
     */
    private static final Log logger = LogFactory.get(IGatewayServiceImpl.class);

    @Override
    public String sendRequest(String url, String requestBodyJson, boolean encrypt) {
        // 加载合作方私钥
        String partnerPrivateKeyPath = this.getClass().getResource(GatewayProperties.PARTNER_PRIVATE_KEY_PATH).getFile();
        String partnerPrivateKey = LoadUtils.loadClassPathFile(partnerPrivateKeyPath);
        // 加载国投云贷公钥
        String cloudloanPublicKeyPath = this.getClass().getResource(GatewayProperties.CLOUDLOAN_PUBLIC_KEY_PATH).getFile();
        String cloudloanPublicKey = LoadUtils.loadClassPathFile(cloudloanPublicKeyPath);

        logger.info("1. 请求地址:{}", url);
        logger.info("2. 请求参数:{}", requestBodyJson);
        // 使用合作方私钥进行签名
        final String sign = this.doSign(GatewayProperties.X_TBC_SOURCE_VALUE, requestBodyJson, partnerPrivateKey);
        logger.info("3. 请求签名结果:{}", sign);
        if (encrypt) {
            // 使用国投云贷公钥进行请求参数加密
            requestBodyJson = this.doEncrypt(requestBodyJson, cloudloanPublicKey);
            logger.info("4. 请求加密结果:{}", requestBodyJson);
        }

        final HttpRequest httpRequest = HttpRequest.post(url)
                // Header ContentType
                .header(Header.CONTENT_TYPE, ContentType.JSON.toString())
                // Header 来源
                .header(GatewayProperties.X_TBC_SOURCE, GatewayProperties.X_TBC_SOURCE_VALUE)
                // Header 签名
                .header(GatewayProperties.X_TBC_SIGN, sign)
                // Body
                .body(requestBodyJson);
        HttpResponse response;
        try {
            response = httpRequest.execute();
            String body = response.body();
            int status = response.getStatus();
            logger.info("5. 请求响应结果, 状态:{}, 内容:{}", status, JSONUtil.toJsonStr(body));
            if (encrypt) {
                body = this.doDecrypt(body, partnerPrivateKey);
                logger.info("5. 请求响应解密:{}, 明文:{}", status, JSONUtil.toJsonStr(body));
            }
            return body;
        } catch (Exception e) {
            logger.error("网关调用异常, {}", e.getMessage(), e);
        }

        return null;
    }

    /**
     * 使用合作方私钥进行签名
     *
     * @param key             关键字
     * @param requestBodyJson 请求参数
     * @param privateKey      合作方私钥
     * @return 签名结果
     */
    private String doSign(String key, String requestBodyJson, String privateKey) {
        final String content = key + requestBodyJson;
        return RSA.sha1WithRSA(content, privateKey);
    }

    /**
     * 使用国投云贷公钥进行请求参数加密
     *
     * @return 加密后请求参数
     */
    private String doEncrypt(String requestBodyJson, String publicKeyStr) {
        String encryptRequestBodyJson = "";
        try {
            RSAPublicKey rsaPublicKey = RSA.loadPublicKeyByStr(publicKeyStr);
            encryptRequestBodyJson = RSA.encrypt(rsaPublicKey, requestBodyJson);
        } catch (Exception e) {
            logger.error("参数加密异常, {}", e.getMessage(), e);
        }
        return encryptRequestBodyJson;
    }

    /**
     * 使用合作方私钥进行响应数据解密
     *
     * @return 解密后响应数据
     */
    private String doDecrypt(String responseBodyJson, String privateKeyStr) {
        String encryptRequestBodyJson = "";
        try {
            RSAPrivateKey rsaPrivateKey = RSA.loadPrivateKeyByStr(privateKeyStr);
            encryptRequestBodyJson = RSA.decrypt(rsaPrivateKey, responseBodyJson);
        } catch (Exception e) {
            logger.error("响应解密异常, {}", e.getMessage(), e);
        }
        return encryptRequestBodyJson;
    }

}
