package com.amit.process.service.queueResourceTest.domain;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * Created by amit on 9/3/17.
 */
@Data
public class Work {


    private Resource resource;
    private Client client;
    private DateTime startAt;
    private DateTime completedAt;


}
