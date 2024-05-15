package com.backend.shopservice.repository;

import com.backend.shopservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShopRepository extends MongoRepository<Product,String> {
    List<Product> findAllByCompanyId(String companyId);
    List<Product> findAllByPriceIsLessThan(Float price);
}
