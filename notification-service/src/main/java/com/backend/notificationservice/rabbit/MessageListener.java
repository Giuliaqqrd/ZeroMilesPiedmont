package com.backend.notificationservice.rabbit;

import com.backend.notificationservice.model.Notification;
import com.backend.notificationservice.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class MessageListener {

    @Autowired
    private NotificationService notificationService;

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void rabbitListener(Notification notification){
        notification.setDateTime(new Date());
        log.info("Notifica da salvare -->" + notification);
        this.notificationService.save(notification);
    }
}
