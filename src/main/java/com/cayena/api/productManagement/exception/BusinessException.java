package com.cayena.api.productManagement.exception;

/**
 * 
 * @author Jose Julai Ritsure
 *
 * Class that handles business exceptions
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8223288522323472929L;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
