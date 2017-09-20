package com.wind.util;


import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;


/**
 * 字符串工具类
 * @author followwwind
 *
 */

public class StringUtils {
	/**
	 * 判断字符串非空
	 * @param str
	 * @return
	 */
	public static boolean strNotEmpty(String str){
		boolean result = false;
		if(str != null && !"".equals(str)){
			result = true;
		}
		return result;
	}
	/**
	 * 随机生成UUID，并去掉-
	 * @return
	 */
	public static String getRandomUUID(){
		UUID uuid = UUID.randomUUID();
		String result = uuid.toString().replaceAll("-", "");
		return result;
	}
	
	private static AtomicLong next = new AtomicLong(1);
	/**
	 * 生成一个13位数的唯一id
	 * @return
	 */
	public static long getPKNum(){
		return next.getAndIncrement() + System.currentTimeMillis();
	}
	
	/**
	 * 校验邮箱
	 * @param email 邮箱
	 * @return
	 */
	public static boolean checkEmail(String email){
		boolean flag = false;
		flag = email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return flag;
	}
	
	/**
	 * 校验手机号码
	 * @param phonenum
	 * @return
	 */
	public static boolean checkPhoneNum(String phonenum){
		boolean flag = false;
		flag = phonenum.matches("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$");
		return flag;
	}
	
	/**
	 * 校验中文
	 * @param chinese
	 * @return
	 */
	public static boolean checkChinese(String chinese){
		boolean flag = false;
		flag = chinese.matches("^[\u4e00-\u9fa5]{0,}$");
		return flag;
	}
}
