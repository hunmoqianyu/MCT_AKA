package com.example.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hash {

    /**
     * hash实例
     * // 创建SHA-256哈希函数实例
     */
    private static MessageDigest digest;

    static {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    ;
    /**
     * 一路hash映射算法
     * @param originalData
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String hash(String originalData) throws NoSuchAlgorithmException {


        // 将原始数据转换为字节数组
        byte[] dataBytes = originalData.getBytes();

        // 计算哈希值d
        byte[] hashBytes = digest.digest(dataBytes);

        // 将哈希值转换为Base64字符串（可选）
        String hashedData = Base64.getEncoder().encodeToString(hashBytes);
        return hashedData;
    }

    public static String bitwiseXOR(String str1, String str2) {
        // 确保两个字符串长度相同
        if (str1.length() != str2.length()) {
            throw new IllegalArgumentException("Input strings must have the same length");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            // 将字符转换为对应的数字
            int char1 = Character.getNumericValue(str1.charAt(i));
            int char2 = Character.getNumericValue(str2.charAt(i));

            // 执行按位异或操作
            int xorResult = char1 ^ char2;

            // 将结果添加到最终字符串
            result.append(xorResult);
        }
        return result.toString();
    }
}
