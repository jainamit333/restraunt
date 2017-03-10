package com.amit.process.common.domain;

import com.amit.process.common.domain.enums.RequestType;
import lombok.Data;

/**
 * Created by amit on 8/3/17.
 */
@Data
public class Request {

    String data;
    RequestType requestType;

}
