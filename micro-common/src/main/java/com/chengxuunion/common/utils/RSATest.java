package com.chengxuunion.common.utils;

import java.util.Map;

public class RSATest {
	
	static String publicKey;
    static String privateKey;

    static {
        try {
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            publicKey = RSAUtils.getPublicKey(keyMap);
            privateKey = RSAUtils.getPrivateKey(keyMap);
            System.err.println("公钥: \n\r" + publicKey);
            System.err.println("私钥： \n\r" + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception {
    	test();
    	testSign();
    	generateAdminPassword();
	}
    
    private static void generateAdminPassword() {
    	try {
			String password = SecurityUtils.encryptMD5("wojiushiwo");
			System.out.println(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    static void test() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String source = "私钥解密";
        System.out.println("\r加密前文字：\r\n" + source);
        byte[] data = source.getBytes("UTF8");
        byte[] encodedData = RSAUtils.encryptByPublicKey(data);
        System.out.println(SecurityUtils.encryptMD5(Base64Utils.encodeByte(encodedData)));
        System.out.println("加密后文字：\r\n" + new String(encodedData));
        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData);
        String target = new String(decodedData);
        System.out.println("解密后文字: \r\n" + target);
    }
    
    static void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");
        String source = "这是一行测试RSA数字签名的无意义文字";
        System.out.println("原文字：\r\n" + source);
        byte[] data = source.getBytes();
        byte[] encodedData = RSAUtils.encryptByPrivateKey(data);
        System.out.println("加密后：\r\n" + new String(encodedData));
        byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData);
        String target = new String(decodedData);
        System.out.println("解密后: \r\n" + target);
        System.err.println("私钥签名——公钥验证签名");
        String sign = RSAUtils.sign(encodedData);
        System.err.println("签名:\r" + sign);
        boolean status = RSAUtils.verify(encodedData, sign);
        System.err.println("验证结果:\r" + status);
    }

}
