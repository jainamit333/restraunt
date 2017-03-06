package com.amit.process.common.domain;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.function.Predicate;

/**
 * Created by amit on 6/3/17.
 */
@Data
public class Request {


    Predicate<Request> IS_PAST_REQUEST = request -> request.dateTime.isBefore(DateTime.now());
    Predicate<Request> DATE_IS_NOT_NULL = request -> null != request.dateTime;
    Predicate<Request> SEAT_REQ_IS_POSITIVE = request -> request.numberOfSeatsRequired >0;
    Predicate<Request> NOT_NULL = request -> null != request;
    Predicate<Request> SEATS_IN_LIMIT = request -> request.numberOfSeatsRequired < Restaurants.MAX_SEAT_LIMIT;
    Predicate<Request> IS_CUSTOMER_VALID = request -> request.client.IS_VALID.test(request.client);

    Predicate<Request> HAS_MINIMUM_INFO = DATE_IS_NOT_NULL.and(SEAT_REQ_IS_POSITIVE);
    Predicate<Request> IS_VALID =  NOT_NULL.and(SEATS_IN_LIMIT).and(IS_CUSTOMER_VALID).and(SEATS_IN_LIMIT);

    private Customer client;
    private DateTime dateTime;
    private int numberOfSeatsRequired;
    private long maxWaitingTimeInMinutes;

}
