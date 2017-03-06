package com.amit.process.common.domain;

import lombok.Data;

/**
 * Created by amit on 6/3/17.
 */
@Data
public abstract class Tax {

    private int priority;
    private boolean applyOnBaseAmount;

    abstract Amount computeAmount(Amount baseAmount);

}
