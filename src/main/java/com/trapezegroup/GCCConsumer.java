package com.trapezegroup;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class GCCConsumer {

    @Autowired
    private String baseUrl;

    @Autowired
    private String userKey;

    public GCCResult getGCCResult(String stopCode) {
        Assert.notNull(stopCode, "stopCode must not be null.");
        Assert.notNull(baseUrl, "baseUrl must not be null. Ensure that you have set one in Application.java.");
        Assert.notNull(userKey, "userKey must not be null. Ensure that you have set one in Application.java.");

        HttpHeaders headers = new HttpHeaders();
        headers.add("user_key", userKey);
        HttpEntity httpEntity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<GCCResult> gccResultResponse;
        try {
            String url = baseUrl + stopCode;
            gccResultResponse = restTemplate.exchange(new URI(url), HttpMethod.GET, httpEntity, GCCResult.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error trying to get GCC result from REST call", e);
        }
        return gccResultResponse.getBody();
    }
}
