package com.chengxuunion.config;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * Rest配置
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
@Configuration
public class RestConfig {
	
	/**
	 * 配置HTTP头信息
	 * @return
	 */
	@Bean
	public HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		
		//生成认证信息
		String auth = "user:password";
		byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodeAuth);
		System.out.println(authHeader);
		
		headers.add("Authorization", authHeader);
		return headers;
	}

	/**
	 * 客户端使用对象配置
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
