package com.chengxuunion.common.model;

/**
 * HTTP状态码
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
public enum HttpStatus {
	
	OK("200", "请求成功"), 
	
	NOT_MODIFIED("304", "所请求的资源未修改"),
	
	BAD_REQUEST("400", "请求无效"),
	
	UN_AUTHORIZED("401", "未授权"),
	
	FORBIDDEN("403", "拒绝访问"),
	
	NOTFOUND("404", "请求的资源不存在"),
	
	METHOD_NOT_ALLOWED("405", "方法不被允许"),
	
	UNSUPPORTED_MEDIA_TYPE("415", "不支持的媒体类型"),
	
	ERROR("500", "服务器内部错误"),
	
	BAD_GATEWAY("502", "网关错误"),
	
	SERVICE_UNAVAILABLE("503", "服务不可用"),
	
	GATEWAY_TIMEOUT("504", "网关超时");
	
	/**
	 * HTTP状态码
	 */
	private String status;
	
	/**
	 * HTTP状态码通用解释
	 */
	private String message;
	
	private HttpStatus(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
	

}
