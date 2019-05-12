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
	private String errorCode;

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
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
