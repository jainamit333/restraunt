package com.amit.process.service.queueResourceTest.exceptions;

/**
 * Created by amit on 9/3/17.
 */
public class ClientCannotBeAcceptedException extends Exception{


    public ClientCannotBeAcceptedException(){
        super();
    }

    public ClientCannotBeAcceptedException(Exception e){
        super(e);
    }

    public ClientCannotBeAcceptedException(String message){
        super(message);
    }
}
