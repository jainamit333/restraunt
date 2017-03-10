package com.amit.process.services.resource.api.domain;

import org.joda.time.DateTime;

/**
 * Created by amit on 8/3/17.
 */
@lombok.Data
public class Table extends Resource {

    private int capacity;
    private int numberOfInfantAccommodate;


    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public boolean isAvailableOn(DateTime dateTime) {
        return false;
    }

    @Override
    public ResourceStatus status() {
        return null;
    }
}
