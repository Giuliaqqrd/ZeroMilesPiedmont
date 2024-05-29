package com.backend.notificationservice.controller;

import com.backend.notificationservice.dto.ResponseMessage;
import com.backend.notificationservice.model.Notification;
import com.backend.notificationservice.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<?> findAllByCompanyId(@RequestParam(name = "companyId") String companyId){
        List<Notification> notifications = this.notificationService.findAllByCompanyId(companyId);
        ResponseMessage<List<Notification>> responseMessage = new ResponseMessage<>(notifications, "Notifiche recuperate con successo");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

}
