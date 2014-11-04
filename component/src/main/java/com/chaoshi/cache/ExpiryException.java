package com.chaoshi.cache;

public class ExpiryException extends Exception {
	public ExpiryException() {
		super("expire!");
	}

	public ExpiryException(String message) {
		super(message); // 调用超类构造器
	}
}
