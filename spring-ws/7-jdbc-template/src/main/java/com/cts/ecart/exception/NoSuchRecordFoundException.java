package com.cts.ecart.exception;

public class NoSuchRecordFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoSuchRecordFoundException(String msg) {
		super(msg);
	}

}
