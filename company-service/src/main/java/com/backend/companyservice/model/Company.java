package com.backend.companyservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Company {
    @Id
    private String id;
    private String name;
    private String piva;
}
