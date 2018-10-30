package com.chengxuunion.common.utils.properties;

import java.io.IOException;

import org.slf4j.LoggerFactory;


/**
 * redis.properties文件读取工具类
 *
 * @author kutome
 * @date 2018年9月6日
 * @version V1.0
 */
public class RedisPropertiesUtils {

	/**
	 * properties文件读取器
	 */
	private PropertiesReader reader;
	
	private RedisPropertiesUtils() {
		try {
			reader = new PropertiesReader("/redis.properties");
		} catch (IOException e) {
			LoggerFactory.getLogger(this.getClass()).error("初始化mail.properties文件读取器出现异常", e);
		}
	}
	
	/**
	 * 内部静态类，实现单例
	 *
	 * @author kutome
	 * @date 2018年9月6日
	 * @version V1.0
	 */
	public static class Singleton {
		private static RedisPropertiesUtils instance = new RedisPropertiesUtils();
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
