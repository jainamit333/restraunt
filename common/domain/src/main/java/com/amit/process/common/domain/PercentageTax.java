package com.amit.process.common.domain;

import lombok.Data;

/**
 * Created by amit on 6/3/17.
 */
@Data
public class PercentageTax extends Tax {

    private float percentage;
    private boolean onBaseAmount;


    @Override
    Amount computeAmount(Amount amount) {

        return Amount.builder()
                     .amount(amount.getAmount()*percentage/100)
                     .currency(amount.getCurrency())
                     .build();
    }
}
