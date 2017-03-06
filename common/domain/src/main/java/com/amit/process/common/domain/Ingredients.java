package com.amit.process.common.domain;

import lombok.Data;
import lombok.experimental.Builder;

/**
 * Created by amit on 6/3/17.
 */
@Data
@Builder
public class Ingredients {

    private Ingredients ingredients;
    private Quantity quantity;
}
