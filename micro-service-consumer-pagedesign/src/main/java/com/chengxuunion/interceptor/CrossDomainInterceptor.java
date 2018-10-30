package com.chengxuunion.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 跨域解决拦截器
 *
 * @author kutome
 * @date 2018年10月26日
 * @version V1.0
 */
public class CrossDomainInterceptor extends HandlerInterceptorAdapter  {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Max-Age", "3600");
        response.addHeader("Access-Control-Allow-Headers", "*");
        //允许客户端发送cookies true表示接收，false不接受
        response.addHeader("Access-Control-Allow-Credentials","true");
        
		return super.preHandle(request, response, handler);
	}
	
}
