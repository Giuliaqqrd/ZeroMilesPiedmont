package com.backend.shopservice.repository;

import com.backend.shopservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepository extends MongoRepository<Product,String> {
}
