package com.xiangtan.exception;

/**
 * 非法请求异常
 * @author Shangyidong
 * @date 2014-12-26
 * @version 1.0
 */
public class IllegalRequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5261391294134137848L;

	public IllegalRequestException() {
		super();
	}
	
	public IllegalRequestException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalRequestException(String message) {
		super(message);
	}

	public IllegalRequestException(Throwable cause) {
		super(cause);
	}
}
