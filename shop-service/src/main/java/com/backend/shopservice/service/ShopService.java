package com.backend.shopservice.service;

import com.backend.shopservice.model.Order;
import com.backend.shopservice.model.Product;
import com.backend.shopservice.repository.OrderRepository;
import com.backend.shopservice.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    private final OrderRepository orderRepository;

    public Product saveProduct(Product product) {
        return this.shopRepository.save(product);

    }

    public List<Product> getAllProducts(){
        return this.shopRepository.findAll();
    }
    public void deleteProduct(String id) {
        this.shopRepository.deleteById(id);
    }

    public List<Product> getByCompanyId(String companyId){
        return shopRepository.findAllByCompanyId(companyId);

    }


    public List<Product> findByPriceLowerThan(float price){
        return shopRepository.findAllByPriceIsLessThan(price);
    }

    public void saveOrder(Order order) {
        this.orderRepository.save(order);

    }
    public List<Order> getAllOrders(String id){
        return orderRepository.findAllById(id);
    }

    public List<Order> getOrdersByCompany(String companyId){
        return orderRepository.findAllByProductCompanyIdOrderByDateTime(companyId);
    }

    public List<Order> getOrdersByUser(String userId){
        return orderRepository.findAllByUserId(userId);
    }

    public List<Order> getOrdersByUserOrderedByDate(String userId){
        return orderRepository.findAllByUserIdOrderByDateTime(userId);
    }


}
