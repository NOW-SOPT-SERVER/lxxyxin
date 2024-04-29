package com.seminar.seminar.common.dto;

import com.seminar.seminar.exception.ErrorMessage;

public record ErrorResponse(
        int status,
        String message
) {
    public static ErrorResponse of(int status, String message){
        return new ErrorResponse(status, message);
    }
    //메서드 오버로딩
    public static ErrorResponse of(ErrorMessage errorMessage){
        return new ErrorResponse(errorMessage.getStatus(), errorMessage.getMessage());
    }
}
