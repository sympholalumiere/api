package com.api.sic.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private static final long serialversionUID =1L;
	
	public RessourceNotFoundException (String  message) {
		super(message);
	}

}
