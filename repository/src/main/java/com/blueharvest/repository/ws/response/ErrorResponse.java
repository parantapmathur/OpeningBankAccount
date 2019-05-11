package com.blueharvest.repository.ws.response;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "errorCode",
    "errorDescription"
})
public class ErrorResponse {

    @JsonProperty("errorCode")
    private String errorCode;
    @JsonProperty("errorDescription")
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

    @JsonProperty("errorCode")
    public String getErrorCode() {
        return errorCode;
    }

    @JsonProperty("errorCode")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("errorDescription")
    public String getErrorDescription() {
        return errorDescription;
    }

    @JsonProperty("errorDescription")
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("errorCode", errorCode).append("errorDescription", errorDescription).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(errorCode).append(errorDescription).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ErrorResponse) == false) {
            return false;
        }
        ErrorResponse rhs = ((ErrorResponse) other);
        return new EqualsBuilder().append(errorCode, rhs.errorCode).append(errorDescription, rhs.errorDescription).isEquals();
    }
}
