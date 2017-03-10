package com.amit.process.service.queueResourceTest.impl.Helper;

import com.amit.process.service.queueResourceTest.anno.Singleton;
import com.amit.process.service.queueResourceTest.impl.managers.ClientManager;
import com.amit.process.service.queueResourceTest.impl.managers.ResourceManager;
import org.joda.time.DateTime;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Created by amit on 9/3/17.
 */
@Singleton
public class ClientManagerHelper {

    private static final ClientManagerHelper CLIENT_MANAGER_HELPER = new ClientManagerHelper();

    private ClientManagerHelper(){}

    public static ClientManagerHelper getInstance(){
        return CLIENT_MANAGER_HELPER;
    }




    public Predicate<ClientManager> IS_QUEQUE_FULL = clientManager -> clientManager.isQuequeFull();

    public Predicate<ResourceManager> RESOURCE_UPPER_TIME = resourceManager -> resourceManager
            .canAcceptRequest(DateTime.now());

    public BiPredicate<ClientManager,ResourceManager> IS_AVAILABLE_FOR_WAITING
            = (clientManager, resourceManager) -> true;


}
