package com.amit.process.service.queueResourceTest;

import com.amit.process.service.queueResourceTest.domain.Error;
import lombok.Builder;
import lombok.Data;

/**
 * Created by amit on 9/3/17.
 */
@Data
@Builder
public class Response {

    private String requestId;
    private Error error;
}
