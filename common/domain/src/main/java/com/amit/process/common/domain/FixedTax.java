package com.amit.process.common.domain;

/**
 * Created by amit on 6/3/17.
 */
public class FixedTax extends Tax {

    private Amount fixedTaxAmount;

    @Override
    Amount computeAmount(Amount baseAmount) {
        return fixedTaxAmount;
    }
}
