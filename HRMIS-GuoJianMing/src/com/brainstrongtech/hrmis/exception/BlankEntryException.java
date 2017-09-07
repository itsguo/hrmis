/**
 * 
 */
package com.brainstrongtech.hrmis.exception;

/**
 * 
 * 控制台空输入异常
 * @author joeyang ong
 *
 */
public class BlankEntryException extends DataAccessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1689566102683105013L;

	/**
	 * 
	 */
	public BlankEntryException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BlankEntryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BlankEntryException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public BlankEntryException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public BlankEntryException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
