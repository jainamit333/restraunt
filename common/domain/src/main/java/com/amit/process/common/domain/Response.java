package com.amit.process.common.domain;

import com.amit.process.common.domain.enums.Status;
import lombok.Data;

/**
 * Created by amit on 8/3/17.
 */
@Data
public class Response {

    private Status status;
    private String responseId;
    private String extraInformation;
}
