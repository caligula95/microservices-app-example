package com.javamaster.client;

import com.javamaster.client.dto.EmailDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationClientImpl implements NotificationClient {

    private final RestTemplate restTemplate;

    @Override
    public void sendEmail(EmailDTO emailDTO) {
        log.info("sending email to {}", emailDTO.getEmail());
        restTemplate.postForLocation("http://notification-app/notification/email", emailDTO);
    }
}
