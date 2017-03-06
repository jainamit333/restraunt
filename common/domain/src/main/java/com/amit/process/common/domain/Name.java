package com.amit.process.common.domain;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

/**
 * Created by amit on 6/3/17.
 */
@Data
public class Name {


    Predicate<Name> IS_VALID = name -> StringUtils.isNoneEmpty(name.firstName);

    private String title;
    private String firstName;
    private String middleName;
    private String lastName;

}
