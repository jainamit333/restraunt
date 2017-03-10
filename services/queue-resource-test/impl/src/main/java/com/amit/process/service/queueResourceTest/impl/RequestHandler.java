package com.amit.process.service.queueResourceTest.impl;

import com.amit.process.service.queueResourceTest.RequestHandlerService;
import com.amit.process.service.queueResourceTest.Response;
import com.amit.process.service.queueResourceTest.domain.Client;
import com.amit.process.service.queueResourceTest.domain.Work;
import com.amit.process.service.queueResourceTest.exceptions.ClientCannotBeAcceptedException;
import com.amit.process.service.queueResourceTest.impl.managers.ClientManager;
import rx.Observable;
import rx.Single;

/**
 * Created by amit on 9/3/17.
 */

public class RequestHandler implements RequestHandlerService{

    @Override
    public Single<Response> addClientToQueue(Client client) {

        return Single.create(singleSubscriber -> {

            try{
                Client addedClient = ClientManager.getInstance().addClientToQueue(client);
                singleSubscriber.onSuccess(Response.builder().requestId(addedClient.getId()).build());

            }catch (ClientCannotBeAcceptedException e){
                singleSubscriber.onError(e);
            }
        });
    }

    @Override
    public Observable<Work> processedWork() {
        return null;
    }

    @Override
    public Observable<Client> rejectedClientRequest() {
        return null;
    }
}
