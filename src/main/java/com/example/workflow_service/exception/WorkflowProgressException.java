package com.example.workflow_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class WorkflowProgressException extends RuntimeException{

    private final HttpStatus httpStatus;

    public WorkflowProgressException(HttpStatus httpStatus,String msg){
        super(msg);
        this.httpStatus = httpStatus;
    }
}
