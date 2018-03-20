package com.mycompany.myapp.exception;

/**
 * @author admin
 *
 */
public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public NotFoundException(String message) {
		super(message);
	}
}
