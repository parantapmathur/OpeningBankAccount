/**
 * 
 */
package com.blueharvest.repository.exception.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.blueharvest.repository.exception.WaitTimeOutException;
import com.blueharvest.repository.ws.response.ErrorResponse;

/**
 * @author paran
 *
 */
public class WaitTimeOutExceptionMapper{


	public Response toResponse(WaitTimeOutException ex) {
		return Response.status(Status.BAD_REQUEST)
				.entity(prepareErrorRecord(ex))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}
	
	public static ErrorResponse prepareErrorRecord(WaitTimeOutException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorCode());
		errorResponse.setErrorDescription(ex.getMessage());
		return errorResponse;
	}

	public Response toResponse(Exception ex) {
		return Response.status(Status.BAD_REQUEST)
				.entity(prepareErrorRecord(ex, Status.BAD_REQUEST.toString()))
				.type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	private Object prepareErrorRecord(Exception ex, String errorCode) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(errorCode);
		errorResponse.setErrorDescription(ex.getMessage());
		return errorResponse;
	}


}
