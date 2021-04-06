package com.example.test.model;

public class ErrorType {
    private String errorCode;
    private String errorDescription;

    public ErrorType(String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorType(String errorCode, String errorDescription) {
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