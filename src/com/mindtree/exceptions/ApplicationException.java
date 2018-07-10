/**
 * 
 */
package com.mindtree.exceptions;

/**
 * @author Ashutosh
 */
public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -941891525480260776L;

	/**
	 * 
	 */
	public ApplicationException() {
		super();
	}

	/**
	 * @param message exception message
	 * @param cause original cause
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message exception message
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * @param cause original exception cause
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
	}
	
}
