package com.backend.shopservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@CompoundIndexes({
        @CompoundIndex(name = "nameprod_idcomp", def = "{'name': 1, 'company.id': 1}")
})
public class Product {
    @Id
    private String id;
    private String name;
    private int quantity;
    private float price;
    private Company company;



}



