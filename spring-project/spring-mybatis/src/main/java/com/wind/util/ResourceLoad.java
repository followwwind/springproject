package com.wind.util;

import java.net.URL;

/**
 * 获取配置文件路径
 * @author followwwind
 *
 */
public class ResourceLoad {
	
	public static URL getConfigfileUrl(String fileName){
		URL url = ResourceLoad.class.getResource("/" + fileName);
		return url;
	}
	
	public static void main(String[] args) {
		System.out.println(ResourceLoad.class.getResource(""));
		System.out.println(ResourceLoad.class.getResource("/office"));
		System.out.println(ResourceLoad.class.getClassLoader().getResource(""));
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
	}
}
