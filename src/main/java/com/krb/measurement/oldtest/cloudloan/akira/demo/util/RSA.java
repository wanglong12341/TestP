package com.krb.measurement.oldtest.cloudloan.akira.demo.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA 签名工具
 *
 * @author cloudloan
 */
public class RSA {

    /**
     *
     */
    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     *
     */
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    /**
     * 加密数据 byte[] 最大长度
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * 解密数据 byte[] 最大长度
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 签名
     * <p>
     * 签名默认算法 SHA1WithRSA
     * <p>
     * 字符集默认 UTF-8
     *
     * @param content    待签名数据
     * @param privateKey 私钥
     * @return 签名后字符串
     */
    public static String sha1WithRSA(String content, String privateKey) {
        return sha1WithRSA(content, privateKey, DEFAULT_CHARSET);
    }

    /**
     * 验签
     * <p>
     * 签名默认算法 SHA1WithRSA
     * <p>
     * 字符集默认 UTF-8
     *
     * @param content   待签名数据
     * @param sign      签名后字符串
     * @param publicKey 公钥
     * @return 验签是否通过 true:false
     */
    public static boolean verifySign(String content, String sign, String publicKey) {
        return verifySign(content, sign, publicKey, DEFAULT_CHARSET);
    }

    /**
     * SHA1WithRSA 签名
     *
     * @param content    待签名数据
     * @param privateKey 私钥字符串(base64加密)
     * @param charset    字符集
     * @return base64编码后的签名值
     */
    public static String sha1WithRSA(String content, String privateKey, Charset charset) {
        try {
            // 使用 PKCS8EncodedKeySpec 加载 RSA 私钥
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyFactory.generatePrivate(keySpec);
            // 构建签名工具 Signature
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(content.getBytes(charset));
            // 生成签名, 并使用 base64 加密
            byte[] signed = signature.sign();
            return new String(Base64.encodeBase64(signed), DEFAULT_CHARSET);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * RSA验签名检查
     *
     * @param content   待签名数据
     * @param sign      签名
     * @param publicKey 公钥字符串(base64加密)
     * @param charset   字符集
     * @return 签名是否正确
     */
    private static boolean verifySign(String content, String sign, String publicKey, Charset charset) {
        try {
            // 使用 X509EncodedKeySpec 加载 RSA 公钥
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(keySpec);
            // 构建签名工具 Signature
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(charset));
            return signature.verify(Base64.decodeBase64(sign));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥字符串（base64加密）
     * @throws Exception 加载公钥时产生的多种异常
     */
    public static RSAPublicKey loadPublicKeyByStr(String publicKeyStr) throws Exception {
        try {
            byte[] buffer = Base64.decodeBase64(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        }
    }

    /**
     * 从字符串中加载私钥
     *
     * @param privateKeyStr 私钥字符串（base64加密）
     * @throws Exception 加载私钥时产生的多种异常
     */
    public static RSAPrivateKey loadPrivateKeyByStr(String privateKeyStr) throws Exception {
        try {
            byte[] buffer = Base64.decodeBase64(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("私钥非法");
        } catch (NullPointerException e) {
            throw new Exception("私钥数据为空");
        }
    }

    /**
     * 公钥加密
     *
     * @param publicKey 公钥
     * @param plainData 明文数据
     * @return 密文数据
     * @throws Exception 加密时产生的多种常信息
     */
    public static String encrypt(RSAPublicKey publicKey, String plainData) throws Exception {
        if (publicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64.encodeBase64String(doEncryptOrDecrypt(cipher, plainData.getBytes(DEFAULT_CHARSET), MAX_ENCRYPT_BLOCK));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("加密公钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("明文长度非法", e);
        } catch (BadPaddingException e) {
            throw new Exception("明文数据已损坏");
        }
    }

    /**
     * 私钥加密
     *
     * @param privateKey 私钥
     * @param plainData  明文数据
     * @return 密文数据
     * @throws Exception 加密时产生的多种常信息
     */
    public static String encrypt(RSAPrivateKey privateKey, String plainData) throws Exception {
        if (privateKey == null) {
            throw new Exception("加密私钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return Base64.encodeBase64String(doEncryptOrDecrypt(cipher, plainData.getBytes(DEFAULT_CHARSET), MAX_ENCRYPT_BLOCK));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("加密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("明文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("明文数据已损坏");
        }
    }

    /**
     * 私钥解密
     *
     * @param privateKey 私钥
     * @param cipherData 密文数据
     * @return 明文数据
     * @throws Exception 解密时产生的多种常信息
     */
    public static String decrypt(RSAPrivateKey privateKey, String cipherData) throws Exception {
        if (privateKey == null) {
            throw new Exception("解密私钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(doEncryptOrDecrypt(cipher, Base64.decodeBase64(cipherData), MAX_DECRYPT_BLOCK), DEFAULT_CHARSET);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("解密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("密文数据已损坏");
        }
    }

    /**
     * 公钥解密
     *
     * @param publicKey  公钥
     * @param cipherData 密文数据
     * @return 明文数据
     * @throws Exception 解密时产生的多种常信息
     */
    public static String decrypt(RSAPublicKey publicKey, String cipherData) throws Exception {
        if (publicKey == null) {
            throw new Exception("解密公钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return new String(doEncryptOrDecrypt(cipher, Base64.decodeBase64(cipherData), MAX_DECRYPT_BLOCK), DEFAULT_CHARSET);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("解密公钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("密文数据已损坏");
        }
    }

    /**
     * 执行分片加密或解密
     *
     * @param cipher          {@link Cipher}
     * @param data            待加密或解密数据
     * @param handleBlockSize 待加密或解密数据分片大小（与算法、证书大小有关）
     * @return 加密或解密后数据
     * @throws IOException               IOException
     * @throws BadPaddingException       BadPaddingException
     * @throws IllegalBlockSizeException IllegalBlockSizeException
     */
    private static byte[] doEncryptOrDecrypt(Cipher cipher, byte[] data, int handleBlockSize) throws IOException, BadPaddingException, IllegalBlockSizeException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int dataLength = data.length;
            int offSet = 0;
            for (int i = 0; dataLength - offSet > 0; offSet = i * handleBlockSize) {
                byte[] cache;
                if (dataLength - offSet > handleBlockSize) {
                    cache = cipher.doFinal(data, offSet, handleBlockSize);
                } else {
                    cache = cipher.doFinal(data, offSet, dataLength - offSet);
                }
                out.write(cache, 0, cache.length);
                ++i;
            }
            return out.toByteArray();
        } catch (IOException e) {
            throw e;
        }
    }

}