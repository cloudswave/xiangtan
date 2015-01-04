package com.xiangtan.exception;

public class PermissonDeniedException extends RuntimeException{
	private static final long serialVersionUID = -5261391294134137848L;

	public PermissonDeniedException() {
		super();
	}
	
	public PermissonDeniedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PermissonDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PermissonDeniedException(String message) {
		super(message);
	}

	public PermissonDeniedException(Throwable cause) {
		super(cause);
	}
}
