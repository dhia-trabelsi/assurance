package com.pfe.auth.Util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NotifSender {
    
    String url = "http://localhost:8084/notification";
    private RestTemplate restTemplate = new RestTemplate();



    public void sendNotif(String message, String type) {
    Map<String, String> requestBody = new HashMap<>();
            requestBody.put("message", message);
            requestBody.put("type", type);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody);
             restTemplate.postForEntity(url, requestEntity, String.class);
    }
}