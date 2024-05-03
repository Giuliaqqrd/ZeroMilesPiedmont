package com.backend.shopservice.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Company {
    private String id;
    private String name;
    private String piva;
}


