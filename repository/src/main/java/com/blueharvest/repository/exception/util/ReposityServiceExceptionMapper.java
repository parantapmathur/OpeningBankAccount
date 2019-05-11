package com.blueharvest.repository.exception.util;

import javax.ws.rs.core.Response;

import com.blueharvest.repository.ws.response.ErrorResponse;

public class ReposityServiceExceptionMapper {

	public Response toResponse(RuntimeException ex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static ErrorResponse prepareErrorRecord(RuntimeException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorCode());
		errorResponse.setErrorDescription(ex.getMessage());
		return errorResponse;
	}

}
