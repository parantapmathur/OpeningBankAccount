package com.blueharvest.repository.exception.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.blueharvest.repository.exception.ReposityServiceException;
import com.blueharvest.repository.ws.response.ErrorResponse;

public class ReposityServiceExceptionMapper {

	public Response toResponse(ReposityServiceException ex) {
		return Response.status(Status.BAD_REQUEST)
				.entity(prepareErrorRecord(ex))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}
	
	public static ErrorResponse prepareErrorRecord(ReposityServiceException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorCode());
		errorResponse.setErrorDescription(ex.getMessage());
		return errorResponse;
	}

	public Response toResponse(RuntimeException ex) {
		return Response.status(Status.BAD_REQUEST)
				.entity(prepareErrorRecord(ex, Status.BAD_REQUEST.toString()))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	private Object prepareErrorRecord(RuntimeException ex, String errorCode) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(errorCode);
		errorResponse.setErrorDescription(ex.getMessage());
		return errorResponse;
	}

}
