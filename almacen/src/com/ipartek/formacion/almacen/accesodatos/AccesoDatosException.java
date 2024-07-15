package com.ipartek.formacion.almacen.accesodatos;

public class AccesoDatosException extends RuntimeException {

	public AccesoDatosException() {
		super();
	}

	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccesoDatosException(String message) {
		super(message);
	}

	public AccesoDatosException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = -361533206882619063L;

}
