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
public class NovusRTConsumer {

    @Autowired
    private String baseUrl;

    @Autowired
    private String userKey;

    public NovusRTResult getNovusRTResult(String stopCode) {
        Assert.hasText(stopCode, "stopCode must not be null.");
        Assert.hasText(baseUrl, "baseUrl must not be null. Ensure that you have set one in Application.java.");
        Assert.hasText(userKey, "userKey must not be null. Ensure that you have set one in Application.java.");

        HttpHeaders headers = new HttpHeaders();
        headers.add("user_key", userKey);
        HttpEntity httpEntity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<NovusRTResult> novusRTResultResponse;
        try {
            String url = baseUrl + stopCode;
            novusRTResultResponse = restTemplate.exchange(new URI(url), HttpMethod.GET, httpEntity, NovusRTResult.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error trying to get NovusRT result from REST call", e);
        }
        return novusRTResultResponse.getBody();
    }
}
