package com.amit.process.services.resource.api.domain;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * Created by amit on 8/3/17.
 */
@Data
public abstract class Resource {

    private String id;
    private ResourceStatus resourceStatus;


    abstract boolean isAvailable();
    abstract boolean isAvailableOn(DateTime dateTime);
    abstract ResourceStatus status();

}
