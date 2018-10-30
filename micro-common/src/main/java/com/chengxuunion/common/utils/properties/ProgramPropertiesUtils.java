package com.chengxuunion.common.utils.properties;

import java.io.IOException;

import org.slf4j.LoggerFactory;


/**
 * program.properties文件读取器
 *
 * @author kutome
 * @date 2018年9月8日
 * @version V1.0
 */
public class ProgramPropertiesUtils {

	/**
	 * properties文件读取器
	 */
	private PropertiesReader reader;
	
	private ProgramPropertiesUtils() {
		try {
			reader = new PropertiesReader("/program.properties");
		} catch (IOException e) {
			LoggerFactory.getLogger(this.getClass()).error("初始化program.properties文件读取器出现异常", e);
		}
	}
	
	/**
	 * 内部静态类，实现单例
	 *
	 * @author kutome
	 * @date 2018年9月8日
	 * @version V1.0
	 */
	public static class Singleton {
		private static ProgramPropertiesUtils instance = new ProgramPropertiesUtils();
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
