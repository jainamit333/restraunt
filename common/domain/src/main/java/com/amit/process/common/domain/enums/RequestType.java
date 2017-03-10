package com.amit.process.common.domain.enums;

/**
 * Created by amit on 8/3/17.
 */
public enum RequestType {

    DINEIN("D"),
    TAKEAWAY("T"),
    ORDER("O");

    private String symbol;

    RequestType(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return this.symbol;
    }
    
}
