package com.amit.process.service.queueResourceTest.domain;

import lombok.Builder;
import lombok.Data;

/**
 * Created by amit on 9/3/17.
 */

public enum  Error {


    QUEQUE_FULL("101","Queque is full currently","Queque is full currently");

    private String code;
    private String message;
    private String description;

    Error(String code,String message,String description){
        this.code=code;
        this.message=message;
        this.description=description;
    }


}
