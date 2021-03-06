package com.callor.readbook.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptEx_01 {

    public static void main(String[] args) {
        StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();

        String name = "Korea";
        String salt = "!Biz1234";
        // 암호화 알고리즘
        // SHA-128, SHA-256, SHA-512, SHA-1024
        String encPolicy = "PBEWithMD5AndDES";

        pbe.setAlgorithm(encPolicy);
        pbe.setPassword(salt);

        // 암호화
        String encText = pbe.encrypt(name);
        System.out.println(encText);

        // 복구화
        String planText = pbe.decrypt(name);
        System.out.println(planText);
    }
}
