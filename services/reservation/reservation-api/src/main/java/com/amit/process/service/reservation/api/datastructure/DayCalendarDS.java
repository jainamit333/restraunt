package com.amit.process.service.reservation.api.datastructure;

import com.amit.process.common.domain.enums.Days;
import rx.Single;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit on 8/3/17.
 */

public class DayCalendarDS {

    private static DayCalendarDS dayCalendarDS = new DayCalendarDS();

    private static final Integer MAX_RESERVATION_DAY = 15;

    private Map<Days,Boolean> openOnMap = new HashMap<>();

    private DayCalendarDS(){}

    public DayCalendarDS getInstance(){
        return dayCalendarDS;
    }

    @PostConstruct
    public void init(){
        //TODO fill available on days data from db
    }

    public Single<Boolean> isOpenOn(Days days){

        return Single.create(singleSubscriber -> {
            try {
                singleSubscriber.onSuccess(isOpen(days));
            }catch (Exception e){
                singleSubscriber.onError(e);
            }
        });
    }

    private Boolean isOpen(Days days){

        return openOnMap.containsKey(days) && null != openOnMap.get(days)
                ? openOnMap.get(days): Boolean.FALSE;

    }

}
