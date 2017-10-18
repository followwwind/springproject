package com.wind.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class CodecUtils {
	/**
	 * 将字符串进行md5加密，并生成64位的字符串
	 * @param str
	 * @return
	 */
	public static String getStrByMd5(String str){
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] input = str.getBytes();
			byte[] output = md.digest(input);
			// 将md5处理后的output结果 利用Base64算法转成字符串
			result = Base64.encodeBase64String(output);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
}
