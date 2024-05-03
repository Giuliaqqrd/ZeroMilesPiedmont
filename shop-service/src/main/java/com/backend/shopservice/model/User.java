package com.backend.shopservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
        @Id
        private String id;
        private String name;
        private String surname;
        @Indexed(unique = true)
        private String email;
}

