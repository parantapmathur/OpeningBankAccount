package com.blueharvest.repository.exception.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.blueharvest.repository.exception.InvalidAccountException;
import com.blueharvest.repository.ws.response.ErrorResponse;

public class InvalidAccountExceptionMapper {

	public Response toResponse(InvalidAccountException ex) {
		return Response.status(Status.BAD_REQUEST)
				.entity(prepareErrorRecord(ex))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}
	
	public static ErrorResponse prepareErrorRecord(InvalidAccountException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorCode());
		errorResponse.setErrorDescription(ex.getMessage());
		return errorResponse;
	}

}
