package com.wind.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类，用于日期格式化等操作
 * 
 * @author followwwind
 *
 */
public class DateUtils {
	/**
	 * 将日期转换成格式化字符串
	 * 
	 * @param date
	 *            日期Date
	 * @param pattern
	 *            日期输出格式 如 yyyy-MM-dd E HH:mm:ss
	 * @example参数详解 E表示星期 HH表示0-23 hh表示0-12 SS表示毫秒
	 * @return
	 */
	public static String dateToStr(Date date, String pattern) {
		String result = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		result = dateFormat.format(date);
		return result;
	}

	/**
	 * 将字符串日期格式化成日期输出
	 * 
	 * @param date
	 *            字符串日期数据
	 * @param pattern
	 *            转换成Date的日期字符串格式
	 * @example "2016-09-22 22:07:03" "yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static Date strToDate(String date, String pattern) {
		Date result = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			result = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 日期之间的差值 单位为天
	 * 
	 * @param start
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @return
	 */
	public static long daysByDate(Date start, Date end) {
		long days = 0;
		long s = start.getTime();
		long e = end.getTime();
		long minus = e - s;
		days = minus / (1000 * 60 * 60 * 24);
		return days;
	}

	/**
	 * 求取当前日期之前或之后的日期
	 * 
	 * @param date
	 *            日期参数
	 * @param distance
	 *            差值 整数表示当前日期之后，负数表示改日期之前
	 * @param unit
	 *            单位 year month day hour minute second
	 * @return
	 */
	public static Date beforeOrAfterForDate(Date date, int distance, String unit) {
		Date result = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int field = 0;
		switch (unit) {
		case "year":
			field = Calendar.YEAR;
			break;
		case "month":
			field = Calendar.MONTH;
			break;
		case "day":
			field = Calendar.DAY_OF_YEAR;
			break;
		case "hour":
			field = Calendar.HOUR;
			break;
		case "minute":
			field = Calendar.MINUTE;
			break;
		case "second":
			field = Calendar.SECOND;
			break;
		default:
			break;
		}
		calendar.add(field, distance);
		result = calendar.getTime();
		return result;
	}
}
