package com.chengxuunion.common.utils.properties;

import java.io.IOException;

import org.slf4j.LoggerFactory;


/**
 * mail.properties配置文件读取工具类
 *
 * @author kutome
 * @date 2018年8月29日
 * @version V1.0
 */
public class MailPropertiesUtils {
	
	/**
	 * properties文件读取器
	 */
	private PropertiesReader reader;
	
	private MailPropertiesUtils() {
		try {
			reader = new PropertiesReader("/mail.properties");
		} catch (IOException e) {
			LoggerFactory.getLogger(this.getClass()).error("初始化mail.properties文件读取器出现异常", e);
		}
	}
	
	/**
	 * 内部静态类，实现单例
	 *
	 * @author kutome
	 * @date 2018年8月29日
	 * @version V1.0
	 */
	public static class Singleton {
		private static MailPropertiesUtils instance = new MailPropertiesUtils();
	}

	/**
	 * 获取PropertiesReader对象
	 * 
	 * @return
	 */
	public static PropertiesReader getInstance() {
		return Singleton.instance.reader;
	}

	
	public static void main(String[] args) {
		System.out.println(MailPropertiesUtils.getInstance().getValue("mail.transport.protocol"));
	}
}
