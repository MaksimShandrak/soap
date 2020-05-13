package com.gear.test.endpoint;

import com.gear.test.soap.GetTimeRequest;
import com.gear.test.util.TimeUtil;
import com.gear.test.soap.GetTimeResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class TimeEndpoint {
    private static final String NAMESPACE_URI = "http://gear.com/test/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTimeRequest")
    @ResponsePayload
    public GetTimeResponse getTime(@RequestPayload GetTimeRequest getTimeRequest) throws DatatypeConfigurationException {
        GetTimeResponse response = new GetTimeResponse();
        response.setDateTime(TimeUtil.getXMLGregorianCalendarNow());

        return response;
    }
}
