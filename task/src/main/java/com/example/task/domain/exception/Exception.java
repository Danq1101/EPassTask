package com.example.task.domain.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Exception extends RuntimeException {

    private String message;

    public String status(Exceptions exceptions){
        switch (exceptions){
            case OK -> message = "Everything is ok";
            case NO_RESULT -> message = "No result exception";
            case INVALID_GLN -> message = "Wrong GLN";
            case GLN_DONT_EXIST -> message = "GLN dont exist";
            case INVALID_DATE -> message = "Invalid date";
            case INVALID_RECORD -> message = "Invalid record";
        }
        return message;
    }

//    public Exception(String message){
//        super(message);
//    }

}
