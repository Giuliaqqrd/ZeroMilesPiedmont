package com.backend.shopservice.repository;

import com.backend.shopservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findAllById(String id);
    List<Order> findAllByProductCompanyIdOrderByDateTime(String companyId);
    List<Order> findAllByUserId(String userId);
    List<Order> findAllByUserIdOrderByDateTime(String id);

}
