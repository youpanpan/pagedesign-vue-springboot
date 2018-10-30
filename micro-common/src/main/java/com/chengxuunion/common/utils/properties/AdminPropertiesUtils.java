package com.chengxuunion.common.utils.properties;

import java.io.IOException;

import org.slf4j.LoggerFactory;


/**
 * admin.properties文件读取器
 *
 * @author kutome
 * @date 2018年9月17日
 * @version V1.0
 */
public class AdminPropertiesUtils {

	
	/**
	 * properties文件读取器
	 */
	private PropertiesReader reader;
	
	private AdminPropertiesUtils() {
		try {
			reader = new PropertiesReader("/admin.properties");
		} catch (IOException e) {
			LoggerFactory.getLogger(this.getClass()).error("初始化admin.properties文件读取器出现异常", e);
		}
	}
	
	/**
	 * 内部静态类，实现单例
	 *
	 * @author kutome
	 * @date 2018年9月17日
	 * @version V1.0
	 */
	public static class Singleton {
		private static AdminPropertiesUtils instance = new AdminPropertiesUtils();
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
