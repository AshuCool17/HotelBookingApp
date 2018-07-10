/**
 * 
 */
package com.mindtree.exceptions;

/**
 * @author Ashutosh
 */
public class PersistException extends DAOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1526371953950881282L;

	/**
	 * 
	 */
	public PersistException() {
		super();
	}

	/**
	 * @param message exception message
	 * @param cause original exception cause
	 */
	public PersistException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message exception message
	 */
	public PersistException(String message) {
		super(message);
	}

	/**
	 * @param cause original exception cause
	 */
	public PersistException(Throwable cause) {
		super(cause);
	}

}
