package com.backend.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "notifications")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Notification {
    private String id;
    private String text;
    private String companyId;
    private boolean read;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateTime;
}
