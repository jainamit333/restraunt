package com.amit.process.service.queueResourceTest.impl.managers;

import com.amit.process.service.queueResourceTest.anno.Singleton;
import com.amit.process.service.queueResourceTest.domain.Client;
import com.amit.process.service.queueResourceTest.exceptions.ClientCannotBeAcceptedException;
import com.amit.process.service.queueResourceTest.impl.Helper.ClientManagerHelper;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by amit on 9/3/17.
 */
@Singleton
public class ClientManager {


    private static final ClientManager CLIENT_MANAGER = new ClientManager();
    private static final int QUEUE_LIMIT = 10;
    private static Queue<Client> clientQueue = new PriorityQueue<>();
    private static Queue<Client> rejectedClientQueue = new LinkedList<>();

    private ClientManager() {}

    public static ClientManager getInstance() {
        return CLIENT_MANAGER;
    }

    public boolean isQuequeFull() {
        synchronized (this) {
            return clientQueue.size() >= QUEUE_LIMIT;
        }
    }

    public int currentQuequeSize() {

        synchronized (this) {
            return clientQueue.size();
        }
    }

    public Client addClientToQueue(Client client) throws ClientCannotBeAcceptedException {

        synchronized (this) {

            ClientManagerHelper clientManagerHelper = ClientManagerHelper.getInstance();
            ResourceManager resourceManager = ResourceManager.getInstance();
            if (clientManagerHelper.IS_QUEQUE_FULL.test(this)
                    && clientManagerHelper.RESOURCE_UPPER_TIME.test(resourceManager)
                    && clientManagerHelper.IS_AVAILABLE_FOR_WAITING.test(this, resourceManager)) {

                return client;
            } else {
                rejectedClientQueue.add(client);
                throw new ClientCannotBeAcceptedException("Client cannot be added to waiting queue , " +
                        "as it is not accepting any new request");

            }
        }
    }

}
