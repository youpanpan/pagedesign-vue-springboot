package com.chengxuunion.common.utils;

/**
 * 字符串工具类
 *
 * @author kutome
 * @date 2018年8月14日
 * @version V1.0
 */
public class StringUtils {
	
	/**
	 * 私有化
	 */
	private StringUtils() {
		
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.equals("") ? true : false;
	}
	
	/**
	 * 判断字符串是否为非空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * 判断两个字符串的值是否相同
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public static boolean isEquals(String str1, String str2) {
		if (str1 != null) {
			return str1.equals(str2);
		}
		
		if (str2 != null) {
			return str2.equals(str1);
		}
		
		return true;
	}
	
	/**
	 * 给str前后添加模糊匹配符%
	 * 
	 * @param str
	 * @return	%str%
	 */
	public static String fillLike(String str) {
		if (isEmpty(str)) {
			return "";
		}
		
		return "%" + str + "%";
	}
}
