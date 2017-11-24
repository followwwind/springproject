package com.wind.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * 解析properties文件
 * @author followwwind
 *
 */
public class PropertiesUtils {
	
	/**
	 * 解析properties文件，用map存储
	 * @param filePath
	 * @return
	 */
	public static Map<String,String> readProperties(String filePath){
		Properties props = new Properties();
		Map<String,String> map = new HashMap<String,String>();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			props.load(in);
			Enumeration<?> enums = props.propertyNames();
			while(enums.hasMoreElements()){
				String key = (String)enums.nextElement();
				String value = props.getProperty(key);
				map.put(key, value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 读取properties的全部信息
	 * @param filePath
	 * @return
	 * @desc 文件名称必须放在资源文件名目录下
	 */
	public static Map<String,String> getProperties(String filePath){
		Map<String,String> map = new HashMap<String,String>();
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(PropertiesUtils.class.getClassLoader().getResourceAsStream(filePath));
			props.load(in);
			Enumeration<?> enums = props.propertyNames();
			while(enums.hasMoreElements()){
				String key = (String)enums.nextElement();
				String value = props.getProperty(key);
				map.put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 写入properties信息
	 * @param filepath
	 * @param map
	 */
	public static void writeProperties(String filepath,Map<String,String>map){
		Properties props = new Properties();
		try {
			// 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(filepath);
            Set<Entry<String, String>> entrys = map.entrySet();
            for(Entry<String, String> entry:entrys){
            	String key = entry.getKey();
            	String value = entry.getValue();
            	props.setProperty(key, value);
            }
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            props.store(fos, "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 输出系统信息
	 */
	public static void outSystemInfo() {
		Properties prop = new Properties();
		prop = System.getProperties(); // 获取系统信息
		prop.list(System.out);
	}
}
