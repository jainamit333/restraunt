package com.amit.process.service.reservation.api;

import com.amit.process.common.domain.DineRequest;
import org.joda.time.DateTime;
import rx.Observable;
import rx.Single;

/**
 * Created by amit on 8/3/17.
 */

public interface QueryHandler {

    Single<Boolean> isResvationPossible(DineRequest dineRequest);

    Observable<DateTime> possibleReservationAvailable(DineRequest dineRequest);

    Single<Float> currentWaitingTimeInMinutes();

    Single<Boolean> isOpenOn(DateTime dateTime);

}
