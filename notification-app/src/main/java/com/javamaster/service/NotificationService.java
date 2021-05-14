package com.javamaster.service;

import com.javamaster.controller.dto.NotificationDTO;

public interface NotificationService {

    void email(NotificationDTO notificationDTO);
}
