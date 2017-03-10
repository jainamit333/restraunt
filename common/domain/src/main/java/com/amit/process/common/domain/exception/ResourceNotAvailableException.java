package com.amit.process.common.domain.exception;

/**
 * Created by amit on 8/3/17.
 */
public class ResourceNotAvailableException extends Exception {

    public ResourceNotAvailableException(){
        super();
    }

    public ResourceNotAvailableException(Exception e){
        super(e);
    }

    public ResourceNotAvailableException(String message){
        super(message);
    }

}
