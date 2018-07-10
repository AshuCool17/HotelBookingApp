/**
 * 
 */
package com.mindtree.exceptions;

/**
 * @author Ashutosh
 */
public class ServiceException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1526371953950881282L;

	/**
	 * 
	 */
	public ServiceException() {
		super();
	}

	/**
	 * @param message exception message
	 * @param cause original exception cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message exception message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause original exception cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}

}
