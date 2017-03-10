package com.amit.process.service.queueResourceTest.impl.managers;

import com.amit.process.service.queueResourceTest.anno.Singleton;
import com.amit.process.service.queueResourceTest.domain.MetaData;
import com.amit.process.service.queueResourceTest.domain.Resource;
import org.joda.time.DateTime;


import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by amit on 9/3/17.
 */
@Singleton
public class ResourceManager {

    private static final ResourceManager RESOURCE_MANAGER = new ResourceManager();

    private static Queue<Resource> RESOURCE_POOL = new LinkedBlockingDeque<>();

    private static Map<Resource,MetaData> resourceMetaData = new HashMap();

    private static final DateTime DATE_TIME_UPPER_LIMIT = new DateTime(0,0,0,20,30);

    private static final int INITIAL_AVERAGE_WORK_TIME_IN_MINUTES = 30;

    private ResourceManager(){}

    public static ResourceManager getInstance(){

        return RESOURCE_MANAGER;
    }

    public boolean canAcceptRequest(DateTime dateTime){

        return dateTime.getHourOfDay()<DATE_TIME_UPPER_LIMIT.getHourOfDay() &&
                dateTime.getMinuteOfHour()<DATE_TIME_UPPER_LIMIT.getMinuteOfHour();

    }

    public int currentExpectedWaitingTime(){


        return 0;
    }




}
