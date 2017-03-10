package com.amit.process.service.queueResourceTest.domain;

import lombok.Data;

/**
 * Created by amit on 9/3/17.
 */
@Data
public class Client implements Domain{

    private String id;

    //TODO add key generation method to application
    @Override
    public String generateId() {
        return this.getClass().getSimpleName();
    }
}
