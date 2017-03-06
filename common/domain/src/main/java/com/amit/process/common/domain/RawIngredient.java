package com.amit.process.common.domain;

import lombok.Data;

/**
 * Created by amit on 6/3/17.
 */
@Data
public class RawIngredient {

    private String id;
    private String name;
    private NutritionTable nutritionTable;

}
