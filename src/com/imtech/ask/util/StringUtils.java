/*
 * @project : Ask
 * @author  : huqiming 
 * @date    : 2013-6-10
 */
package com.imtech.ask.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串工具类
 */
public class StringUtils {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public static String formatDate(long time) {
		return format.format(new Date(time));
	}

	public static String formatDate() {
		return format.format(new Date());
	}
}
