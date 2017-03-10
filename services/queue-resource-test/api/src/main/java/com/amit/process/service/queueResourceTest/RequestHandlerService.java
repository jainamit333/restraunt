package com.amit.process.service.queueResourceTest;

import com.amit.process.service.queueResourceTest.domain.Client;
import com.amit.process.service.queueResourceTest.domain.Work;
import rx.Observable;
import rx.Single;

/**
 * Created by amit on 9/3/17.
 */

public interface RequestHandlerService {


    Single<Response> addClientToQueue(Client client);

    Observable<Work> processedWork();

    Observable<Client> rejectedClientRequest();

}
