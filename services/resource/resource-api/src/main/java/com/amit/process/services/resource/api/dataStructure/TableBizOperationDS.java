package com.amit.process.services.resource.api.dataStructure;

import com.amit.process.common.domain.exception.ResourceAlreadyFreeException;
import com.amit.process.common.domain.exception.ResourceNotAvailableException;
import com.amit.process.services.resource.api.domain.Table;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by amit on 8/3/17.
 */

public class TableBizOperationDS {

    private static TableBizOperationDS tableBizOperationDS = new TableBizOperationDS();

    public static TableBizOperationDS getInstance(){
        return tableBizOperationDS;
    }

    private ListMultimap<Integer, Table> totalTablesSeatWiseMap = ArrayListMultimap.create();
    private ListMultimap<Integer, Table> availableTablesSeatWiseMap = ArrayListMultimap.create();
    private Map<String,Table> blockedResource = new HashMap<>();
    private List<Integer> seatsSet = new LinkedList<>();


    @PostConstruct
    public void init(){
        //TODO fill multimap and seat list from database while application boot-up
        //TODO also sort the seatSet
    }

    private TableBizOperationDS(){}

    private boolean addTable(Table table){

        assert null != table;
        return totalTablesSeatWiseMap.put(table.getCapacity(),table);
    }
    //TODO need to put check of list is empty or not
    public  Table getTableBySeat(int capacity) throws ResourceNotAvailableException {

        synchronized (this){

            if(availableTablesSeatWiseMap.containsKey(capacity)){
                Table table = availableTablesSeatWiseMap.get(capacity).remove(0);
                blockedResource.put(table.getId(),table);
                return table;
            }else {
                throw new ResourceNotAvailableException("Table not available for seat capacity "+ capacity);
            }
        }
    }

    public void releaseResource(String tableId) throws ResourceAlreadyFreeException {

        synchronized (this){

            if(blockedResource.containsKey(tableId)){
                Table table = blockedResource.remove(tableId);
                availableTablesSeatWiseMap.put(table.getCapacity(),table);
            }else{
                throw new ResourceAlreadyFreeException("Table requested for release is already free "+tableId);
            }
        }
    }

    public List<Integer> minSeatsRequired(int numberOfCustomers){

        return seatsSet.stream()
                       .filter(integer -> integer>=numberOfCustomers)
                       .collect(Collectors.toList());

    }

}
