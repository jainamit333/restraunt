package com.amit.process.common.domain;

import com.amit.process.common.domain.enums.Unit;
import lombok.Data;

/**
 * Created by amit on 6/3/17.
 */
@Data
public class Quantity {

    private float value;
    private Unit unit;
}
