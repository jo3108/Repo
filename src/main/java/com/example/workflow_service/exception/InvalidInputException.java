package com.example.workflow_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidInputException extends RuntimeException{

    private final HttpStatus httpStatus;

    public InvalidInputException(HttpStatus httpStatus,String msg){
        super(msg);
        this.httpStatus = httpStatus;
    }
}
