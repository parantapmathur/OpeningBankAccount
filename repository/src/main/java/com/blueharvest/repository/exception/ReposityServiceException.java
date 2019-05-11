/**
 * 
 */
package com.blueharvest.repository.exception;

/**
 * @author Parantap Mathur
 *
 */
public class ReposityServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4519782435069472016L;

	/**
	 * 
	 */
	public ReposityServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ReposityServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ReposityServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ReposityServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ReposityServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
