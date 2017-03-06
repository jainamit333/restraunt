package com.amit.process.common.domain;

import com.amit.process.common.domain.enums.Currency;
import lombok.Data;
import lombok.experimental.Builder;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by amit on 6/3/17.
 */
@Data
@Builder
public class Amount {

    Predicate<Amount> SAME_CURRENCY = amount1 -> this.getCurrency().equals(amount1.getCurrency());

    Function<Amount,Amount> ADDER = amount1 -> {
        this.setAmount(this.amount+amount1.getAmount());
        return this;
    };

    private float amount;
    private Currency currency;

}
