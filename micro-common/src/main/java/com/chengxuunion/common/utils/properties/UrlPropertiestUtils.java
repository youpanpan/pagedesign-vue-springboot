package com.chengxuunion.common.utils.properties;

import java.io.IOException;

import org.slf4j.LoggerFactory;


/**
 * url.properties文件读取器
 *
 * @author kutome
 * @date 2018年9月13日
 * @version V1.0
 */
public class UrlPropertiestUtils {

	/**
	 * properties文件读取器
	 */
	private PropertiesReader reader;
	
	private UrlPropertiestUtils() {
		try {
			reader = new PropertiesReader("/url.properties");
		} catch (IOException e) {
			LoggerFactory.getLogger(this.getClass()).error("初始化url.properties文件读取器出现异常", e);
		}
	}
	
	/**
	 * 内部静态类，实现单例
	 *
	 * @author kutome
	 * @date 2018年9月13日
	 * @version V1.0
	 */
	public static class Singleton {
		private static UrlPropertiestUtils instance = new UrlPropertiestUtils();
	}

	/**
	 * 获取PropertiesReader对象
	 * 
	 * @return
	 */
	public static PropertiesReader getInstance() {
		return Singleton.instance.reader;
	}
	
}
