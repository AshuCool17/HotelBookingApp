/**
 * 
 */
package com.mindtree.exceptions;

/**
 * @author Ashutosh
 */
public class FetchException extends DAOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1526371953950881282L;

	/**
	 * 
	 */
	public FetchException() {
		super();
	}

	/**
	 * @param message exception message
	 * @param cause original exception cause
	 */
	public FetchException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message exception message
	 */
	public FetchException(String message) {
		super(message);
	}

	/**
	 * @param cause original exception cause
	 */
	public FetchException(Throwable cause) {
		super(cause);
	}

}
