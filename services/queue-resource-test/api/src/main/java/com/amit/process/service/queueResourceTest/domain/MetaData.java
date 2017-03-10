package com.amit.process.service.queueResourceTest.domain;

import com.amit.process.service.queueResourceTest.enums.Status;
import lombok.Data;

/**
 * Created by amit on 9/3/17.
 */
@Data
public class MetaData {


    private Status status;
    private int averageWorkingPerClient;


}
