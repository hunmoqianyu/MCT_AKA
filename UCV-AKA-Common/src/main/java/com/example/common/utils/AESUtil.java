package com.example.common.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    // 将密钥转换为SecretKey
    private static SecretKeySpec createSecretKey(String key) {
        return new SecretKeySpec(key.getBytes(), ALGORITHM);
    }

    // 加密方法
    public static String encrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, createSecretKey(key));
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // 解密方法
    public static String decrypt(String encryptedData, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, createSecretKey(key));
        byte[] decryptedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] originalBytes = cipher.doFinal(decryptedBytes);
        return new String(originalBytes);
    }
}