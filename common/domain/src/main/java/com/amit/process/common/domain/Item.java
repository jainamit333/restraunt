package com.amit.process.common.domain;

import com.amit.process.common.domain.enums.Category;
import com.amit.process.common.domain.enums.Cuisine;
import com.amit.process.common.domain.enums.Variant;
import lombok.Data;
import lombok.experimental.Builder;

import java.util.Map;
import java.util.Set;

/**
 * Created by amit on 6/3/17.
 */
@Data
@Builder
public class Item {


    private String id;
    private String name;
    private String description;
    private Ingredients ingredients;
    private Availability availability;
    private Cuisine cuisine;
    private Category category;
    private Map<Variant,Amount> priceMap;
    private Set<Addons> addonsAvailable;
    private NutritionTable nutritionTable;
    private Recipes recipes;


    public Set<Variant> variantsAvailable(){
        return priceMap.keySet();
    }


}
