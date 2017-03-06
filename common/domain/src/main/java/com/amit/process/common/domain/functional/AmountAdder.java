package com.amit.process.common.domain.functional;

import com.amit.process.common.domain.Amount;

import java.util.function.BiFunction;

/**
 * Created by amit on 6/3/17.
 */
public class AmountAdder implements BiFunction<Amount,Amount,Amount> {


    @Override
    public Amount apply(Amount amount, Amount amount2) {

        if(amount.getCurrency().equals(amount2.getCurrency())){
             return Amount.builder().amount(amount.getAmount()+amount2.getAmount())
                     .currency(amount.getCurrency()).build();
        }
        //TODO else use currency converter and return the value
        return null;



    }
}
