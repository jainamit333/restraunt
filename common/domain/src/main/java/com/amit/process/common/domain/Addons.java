package com.amit.process.common.domain;

import com.amit.process.common.domain.enums.Variant;
import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * Created by amit on 6/3/17.
 */
@Data
public class Addons {

    private String id;
    private String name;
    private String description;
    private Map<Variant,Amount> priceMap;

    public Set<Variant> variantsAvailable(){
        return priceMap.keySet();
    }
}
