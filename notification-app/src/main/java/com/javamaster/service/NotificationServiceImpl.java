package com.javamaster.service;

import com.javamaster.controller.dto.NotificationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void email(NotificationDTO notificationDTO) {
        log.info("sending email {}", notificationDTO);
    }
}
