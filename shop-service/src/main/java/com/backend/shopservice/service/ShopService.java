package com.backend.shopservice.service;

import com.backend.shopservice.model.Notification;
import com.backend.shopservice.model.Order;
import com.backend.shopservice.model.Product;
import com.backend.shopservice.rabbit.RabbitMqConfig;
import com.backend.shopservice.repository.OrderRepository;
import com.backend.shopservice.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    private final OrderRepository orderRepository;
    private final RabbitTemplate rabbitTemplate;

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


    private void sendNotification(Order order){
        String text = "Ordine ricevuto da " + order.getUser().getEmail();
        String companyId = order.getCompanyId();
        Notification notification = new Notification(text, companyId);
        rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE, RabbitMqConfig.ROUTING_KEY, notification);
    }


    public Order saveOrder(Order order) {
        order.setDateTime(new Date());
        Order saved_order = this.orderRepository.save(order);
        sendNotification(saved_order);
        return saved_order;
    }
    public List<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }
    public List<Order> getAllOrders(String id){
        return orderRepository.findAllById(id);
    }

    public List<Order> getOrdersByUser(String userId){
        return orderRepository.findAllByUserId(userId);
    }

    public List<Order> getOrdersByUserOrderedByDate(String userId){
        return orderRepository.findAllByUserIdOrderByDateTime(userId);
    }

    public List<Order> getOrdersByCompanyId(String companyId) {
        return this.orderRepository.findOrdersByCompanyId(companyId);
    }


}
