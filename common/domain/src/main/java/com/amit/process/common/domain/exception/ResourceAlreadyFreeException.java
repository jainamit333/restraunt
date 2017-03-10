package com.amit.process.common.domain.exception;

/**
 * Created by amit on 8/3/17.
 */
public class ResourceAlreadyFreeException extends Exception {


    public ResourceAlreadyFreeException(){
        super();
    }

    public ResourceAlreadyFreeException(Exception e){
        super(e);
    }

    public ResourceAlreadyFreeException(String message){
        super(message);
    }
}
