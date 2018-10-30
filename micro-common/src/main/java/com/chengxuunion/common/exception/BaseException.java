package com.chengxuunion.common.exception;

/**
 * 基础异常类
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
@SuppressWarnings("serial")
public class BaseException extends Exception {

	/**
	 * 是否正常抛出，为true则表示正常抛出，是属于人为逻辑上的处理
	 */
	private boolean normalThrow = false;
	
	/**
	 * 状态码
	 */
	private int status = 500;

	public BaseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public boolean isNormalThrow() {
		return normalThrow;
	}

	public void setNormalThrow(boolean normalThrow) {
		this.normalThrow = normalThrow;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
