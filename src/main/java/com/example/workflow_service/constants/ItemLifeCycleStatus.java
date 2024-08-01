package com.example.workflow_service.constants;

import com.example.workflow_service.exception.InvalidInputException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;


@AllArgsConstructor
public enum ItemLifeCycleStatus {

    SETUP("Setup"),
    READY_TO_ORDER("Ready_To_Order"),

    READY_TO_SELL("Ready To Sell");

    private final String value;

    @Override
    public String toString(){return value;}

    private static final Map<String,ItemLifeCycleStatus> lookup = Arrays.stream(values()).
            collect(toMap(status->status.toString().toLowerCase(), Function.identity()));

    public static ItemLifeCycleStatus from(String code){

        if(null!=lookup.get(code.toLowerCase())){
            return lookup.get(code.toLowerCase());
        }else {
            throw new InvalidInputException(HttpStatus.BAD_REQUEST,"Invalid "+code+"for ItemLifeCycleStatus");
        }
    }


}
