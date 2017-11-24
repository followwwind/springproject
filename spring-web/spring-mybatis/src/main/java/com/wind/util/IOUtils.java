package com.wind.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO流工具类
 * @author followwwind
 *
 */
public class IOUtils {
	
	/**
	 * 关闭输入流
	 * @param in
	 */
	public static void close(InputStream in){
		if(in != null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭输出流
	 * @param out
	 */
	public static void close(OutputStream out){
		if(out != null){
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 判断文件是否存在
	 * @param path
	 * @return
	 */
	public static boolean isexist(String path){
		boolean flag = false;
		File file = new File(path);
		if(file.exists() && file.isFile()){
			flag = true;
		}
		return flag;
	}
}
