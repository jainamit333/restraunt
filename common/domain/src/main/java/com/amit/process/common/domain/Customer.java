package com.amit.process.common.domain;

import com.amit.process.common.domain.enums.Gender;
import lombok.Data;

import java.util.function.Predicate;

/**
 * Created by amit on 6/3/17.
 */
@Data
public class Customer {

    Predicate<Customer> IS_VALID = customer -> customer.name.IS_VALID.test(this.name)
                                               && customer.contactInformation.IS_VALID.test(this.contactInformation);

    private Name name;
    private ContactInformation contactInformation;
    private Gender gender;



}
