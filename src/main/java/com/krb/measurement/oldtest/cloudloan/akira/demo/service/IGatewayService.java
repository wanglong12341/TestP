package com.krb.measurement.oldtest.cloudloan.akira.demo.service;

/**
 * 国投云贷网关服务
 *
 * @author cloudloan
 * @since 2019/10/24
 */
public interface IGatewayService {

    /**
     * 发送请求
     *
     * @param url       请求地址
     * @param paramJson 参数列表 json 格式
     * @param encrypt   是否需要加密解密
     * @return 响应结果
     */
    String sendRequest(String url, String paramJson, boolean encrypt);
}
