/**
 * 
 */
package com.blueharvest.repository.exception;

/**
 * @author Parantap Mathur
 *
 */
public class InsufficientBalanceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2711894985468721468L;
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
	public InsufficientBalanceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InsufficientBalanceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InsufficientBalanceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public InsufficientBalanceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public InsufficientBalanceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	

}
