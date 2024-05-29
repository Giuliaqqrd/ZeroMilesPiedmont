package com.backend.notificationservice.service;

import com.backend.notificationservice.model.Notification;
import com.backend.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public List<Notification> findAllByCompanyId(String companyId) {
        return notificationRepository.findAllByCompanyIdAndReadIsFalse(companyId);
    }

    public void save(Notification notification) {
        this.notificationRepository.save(notification);
    }
}
