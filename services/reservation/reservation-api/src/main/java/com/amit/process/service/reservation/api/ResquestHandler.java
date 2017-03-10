package com.amit.process.service.reservation.api;

import com.amit.process.common.domain.DineRequest;
import com.amit.process.service.reservation.api.domain.ReservationResponse;
import rx.Completable;
import rx.Single;

/**
 * Created by amit on 8/3/17.
 */
public interface ResquestHandler {

    Single<ReservationResponse> createReservation(DineRequest dineRequest);

    Single<ReservationResponse> updateReservation(DineRequest dineRequest);

    Completable deleteReservation(String resvationID);


}
