package com.marson.cursomcNovo.servicies.exceptions;

public class ObjectNotFoudException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public ObjectNotFoudException(String msg) {
	// TODO Auto-generated constructor stub
		super(msg);
	
	}
	
	public ObjectNotFoudException(String msg , Throwable cause) {
		// TODO Auto-generated constructor stub
		super(msg, cause);
	}
	
}
