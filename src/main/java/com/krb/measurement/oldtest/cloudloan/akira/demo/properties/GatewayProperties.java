package com.krb.measurement.oldtest.cloudloan.akira.demo.properties;

/**
 * 常量定义
 *
 * @author cloudloan
 */
public class GatewayProperties {

    /**
     * 请求 HEADER 签名 KEY
     */
    public static final String X_TBC_SIGN = "X-TBC-SIGN";

    /**
     * 请求 HEADER 来源 KEY
     */
    public static final String X_TBC_SOURCE = "X-TBC-SOURCE";

    /**
     * X_TBC_SOURCE 值
     * <p>
     * 不同来源应有不同的值
     */
    public static String X_TBC_SOURCE_VALUE;

    /**
     * 合作方私钥存放路径
     * <p>
     * 不同来源应有不同的路径、私钥
     */
    public static String PARTNER_PRIVATE_KEY_PATH;

    /**
     * 国投云贷公钥存放路径
     * <p>
     * 不同来源应有不同的路径、私钥
     */
    public static String CLOUDLOAN_PUBLIC_KEY_PATH;
}
