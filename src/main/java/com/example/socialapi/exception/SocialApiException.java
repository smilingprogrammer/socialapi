package com.example.socialapi.exception;

import org.springframework.http.HttpStatus;

public class SocialApiException extends RuntimeException{

    private final HttpStatus status;
    private final String message;

    public SocialApiException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public SocialApiException(String message, HttpStatus status, Throwable exception) {
        super(exception);
        this.status = status;
        this.message = message;
    }
}
