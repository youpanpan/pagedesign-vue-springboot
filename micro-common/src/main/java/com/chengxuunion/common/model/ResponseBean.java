package com.chengxuunion.common.model;

/**
 * 响应实体
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
public class ResponseBean {
	
	/**
	 * 状态码
	 */
	private String status;
	
	/**
	 * 描述信息
	 */
	private String message;
	
	/**
	 * 返回的数据
	 */
	private Object data;
	
	public ResponseBean() {
		
	}
	
	public ResponseBean(HttpStatus httpStatus, Object data) {
		this(httpStatus.getStatus(), httpStatus.getMessage(), data);
	}
	
	public ResponseBean(String status, String message) {
		this(status, message, null);
	}
	
	public ResponseBean(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
