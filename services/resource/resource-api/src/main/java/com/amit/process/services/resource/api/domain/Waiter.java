package com.amit.process.services.resource.api.domain;

import com.amit.process.common.domain.Name;
import lombok.Data;
import org.joda.time.DateTime;

/**
 * Created by amit on 8/3/17.
 */
@Data
public class Waiter implements Resource{

    private Name name;

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public boolean isAvailableOn(DateTime dateTime) {
        return false;
    }

    @Override
    public ResourceStatus status() {
        return null;
    }
}
