package com.chengxuunion.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.chengxuunion.interceptor.CrossDomainInterceptor;

/**
 * Web配置
 *
 * @author kutome
 * @date 2018年10月26日
 * @version V1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CrossDomainInterceptor());
	}
	
}
