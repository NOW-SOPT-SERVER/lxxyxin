package com.seminar.seminar.exception;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
