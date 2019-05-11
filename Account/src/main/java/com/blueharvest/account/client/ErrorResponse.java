package com.blueharvest.account.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {

    
    private String errorCode;
    
    private String errorDescription;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ErrorResponse() {
    }

    /**
     * 
     * @param errorCode
     * @param errorDescription
     */
    public ErrorResponse(String errorCode, String errorDescription) {
        super();
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    
    public String getErrorCode() {
        return errorCode;
    }

    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    
    public String getErrorDescription() {
        return errorDescription;
    }

    
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
