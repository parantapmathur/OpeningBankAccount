/**
 * 
 */
package com.blueharvest.repository.exception;

/**
 * @author Parantap Mathur
 *
 */
public class InvalidAccountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8741075736422072370L;

	/**
	 * 
	 */
	public InvalidAccountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidAccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public InvalidAccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public InvalidAccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
