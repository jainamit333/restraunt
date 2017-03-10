package com.amit.process.common.domain;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.function.Predicate;

/**
 * Created by amit on 6/3/17.
 */
@Data
public class DineRequest {


    Predicate<DineRequest> IS_PAST_REQUEST = dineRequest -> dineRequest.dateTime.isBefore(DateTime.now());
    Predicate<DineRequest> DATE_IS_NOT_NULL = dineRequest -> null != dineRequest.dateTime;
    Predicate<DineRequest> SEAT_REQ_IS_POSITIVE = dineRequest -> dineRequest.numberOfSeatsRequired >0;
    Predicate<DineRequest> NOT_NULL = dineRequest -> null != dineRequest;
    Predicate<DineRequest> SEATS_IN_LIMIT = dineRequest -> dineRequest.numberOfSeatsRequired < Restaurants.MAX_SEAT_LIMIT;
    Predicate<DineRequest> IS_CUSTOMER_VALID = dineRequest -> dineRequest.client.IS_VALID.test(dineRequest.client);

    Predicate<DineRequest> HAS_MINIMUM_INFO = DATE_IS_NOT_NULL.and(SEAT_REQ_IS_POSITIVE);
    Predicate<DineRequest> IS_VALID =  NOT_NULL.and(SEATS_IN_LIMIT).and(IS_CUSTOMER_VALID).and(SEATS_IN_LIMIT);

    private Customer client;
    private DateTime dateTime;
    private int numberOfSeatsRequired;
    private long maxWaitingTimeInMinutes;

}
