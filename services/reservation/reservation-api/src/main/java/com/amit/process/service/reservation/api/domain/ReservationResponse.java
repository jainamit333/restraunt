package com.amit.process.service.reservation.api.domain;

import lombok.Data;

/**
 * Created by amit on 8/3/17.
 */
@Data
public class ReservationResponse {

    private String id;
    private ReservationStatus reservationStatus;


}
