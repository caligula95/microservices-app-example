package com.javamaster.controller;

import com.javamaster.controller.dto.NotificationDTO;
import com.javamaster.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/email")
    public ResponseEntity<Void> email(@RequestBody NotificationDTO notificationDTO){
        log.info("handling send email: {}", notificationDTO);
        notificationService.email(notificationDTO);
        return ResponseEntity.ok().build();
    }
}
