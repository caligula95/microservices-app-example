package com.javamaster.client;

import com.javamaster.client.dto.EmailDTO;

public interface NotificationClient {

    void sendEmail(EmailDTO emailDTO);
}
