package mx.com.axity.commons.to;

import org.springframework.http.ResponseEntity;

public class ErrorTo  {
    private long errorCode;
    private String errorMessage;

    public ErrorTo() {
    }

    public ErrorTo(long errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
