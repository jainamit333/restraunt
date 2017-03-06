package com.amit.process.common.domain;

import org.joda.time.DateTime;

/**
 * Created by amit on 6/3/17.
 */
public interface Availability {


    boolean isAvalibleRightNow();
    boolean isAvailableAt(DateTime dateTime);


}
