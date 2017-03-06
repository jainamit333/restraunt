package com.amit.process.app.test;


import rx.Observable;
import rx.Observer;
import rx.Single;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 6/3/17.
 */

public class CreateObservable {

    //create empty observable
    public Observable empty(){
        return Observable.create(Observer::onCompleted);
    }

    public  Single<String> singleValue(){
        return Single.create(singleSubscriber ->
                singleSubscriber.onSuccess("test single value"));
    }

    public Single<String> singleValueError(){
         return Single.create(singleSubscriber -> {
             singleSubscriber.onError(new RuntimeException());
         });
    }

    public Observable<String> singleValueObs(){
        return Observable.create(s->{
            s.onNext("single value");
            s.onCompleted();
        });
    }

    public Observable<String> multipleValue(){

        return Observable.create(s->{
            s.onNext("first value");
            s.onNext("second value");
            s.onNext("third value");
            s.onCompleted();
        });
    }

    //creating event from FROM
    public Observable<String> multipleFromList(){

        List<String> list  = new ArrayList<String>(){{add("a");add("b");}};
        return Observable.from(list);

    }

    //creating event from list
    public Observable<String> justList(){
        return Observable.just("a","b");
    }

    //wrong way to create event from just
    public Observable<String> justListWrong(){

        return Observable.just(getAttribute());
    }

    //one event will be generated , then error even will be generated
    public Observable<String> errorObservable(){

        return Observable.create(subscriber -> {
            subscriber.onNext("single value");
            subscriber.onError(new RuntimeException());
            subscriber.onCompleted();
        });
    }

    //on error event is generated as it will be catched
    public Observable<Integer> errorHandling(){

        return Observable.create(subscriber -> {
            try{
                subscriber.onNext(1/0);
                subscriber.onCompleted();
            }catch (Exception e){
                subscriber.onError(new Exception(e));
            }
        });
    }

    //on error event will be generated even when it is not catched
    public Observable<Integer> errorWithoutHandling(){

        return Observable.create(subscriber -> {
                subscriber.onNext(1/0);
                subscriber.onCompleted();
        });
    }

    //All above creation method are cold observable
    public String getAttribute(){
        return "method will be executed";
    }





}
