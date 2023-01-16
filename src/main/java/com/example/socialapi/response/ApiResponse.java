package com.example.socialapi.response;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ApiResponse implements Serializable {

    private Boolean success;
    private String message;
    private HttpStatus status;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, String message, HttpStatus status) {
        this.success = success;
        this.message = message;
        this.status = status;
    }
}
