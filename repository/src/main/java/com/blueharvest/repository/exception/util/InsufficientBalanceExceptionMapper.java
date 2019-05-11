package com.blueharvest.repository.exception.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.blueharvest.repository.exception.InsufficientBalanceException;
import com.blueharvest.repository.ws.response.ErrorResponse;
import com.blueharvest.repository.ws.util.WSUtils;

public class InsufficientBalanceExceptionMapper implements ExceptionMapper<InsufficientBalanceException>{

	@Override
	public Response toResponse(InsufficientBalanceException exception) {
		return Response.status(Status.BAD_REQUEST)
				.entity(prepareErrorRecord(exception))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}
	
	private ErrorResponse prepareErrorRecord(InsufficientBalanceException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorCode());
		errorResponse.setErrorDescription(ex.getMessage());
		return errorResponse;
	}

}
