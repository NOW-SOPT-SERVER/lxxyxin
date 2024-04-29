package com.seminar.seminar.exception;

import com.seminar.seminar.common.dto.ErrorResponse;

public class BusinessException extends RuntimeException{
    private ErrorMessage errorMessage;
    public BusinessException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
