package com.example.socialapi.exception;

import com.example.socialapi.response.ApiResponse;

public class BadRequestException extends RuntimeException{

    private static final Long serialId = 1L;
    private ApiResponse apiResponse;

    public BadRequestException(ApiResponse apiResponse){
        super();
        this.apiResponse = apiResponse;
    }

    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(String message, Throwable cause){
        super(message, cause);
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }
}
