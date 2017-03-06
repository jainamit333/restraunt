package com.amit.process.common.domain;

import com.amit.process.common.domain.enums.ContactOption;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

/**
 * Created by amit on 6/3/17.
 */
@Data
public class ContactInformation {

    Predicate<ContactInformation> IS_VALID = contactInformation -> null != contactInformation.contactPreference
            && contactInformation.contactPreference.equals(ContactOption.EMAIL)?
                StringUtils.isNoneEmpty(contactInformation.emailId) :
                    StringUtils.isNoneEmpty(contactInformation.mobileNumber) &&
                    StringUtils.isNoneEmpty(contactInformation.countryCode);

    private String emailId;
    private String mobileNumber;
    private String countryCode;
    private ContactOption contactPreference;

}
