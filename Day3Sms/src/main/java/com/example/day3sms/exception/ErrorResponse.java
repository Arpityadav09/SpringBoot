package com.example.day3sms.exception;

import java.util.Map;

public class ErrorResponse {
    private int status;
    private String message;
    private Map<String,String> errors;

    public ErrorResponse(int status, String message, Map<String, String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

}
