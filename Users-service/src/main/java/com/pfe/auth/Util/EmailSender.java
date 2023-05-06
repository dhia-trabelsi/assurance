package com.pfe.auth.Util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmailSender {


    String url = "http://localhost:8084/email";
    private RestTemplate restTemplate = new RestTemplate();


    public void sendEmail(EmailRequest emailRequest) {
        

        restTemplate.postForEntity(url, emailRequest, String.class);
    }
    
}
