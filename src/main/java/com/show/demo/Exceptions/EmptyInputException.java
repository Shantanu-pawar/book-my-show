package com.show.demo.Exceptions;

public class EmptyInputException extends RuntimeException {
    private String errorCode;
    private String errorMsg;

    public EmptyInputException(String errorCode, String errorMsg) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
