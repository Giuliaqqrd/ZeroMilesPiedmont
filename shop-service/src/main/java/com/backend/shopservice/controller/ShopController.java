package com.backend.shopservice.controller;

import com.backend.shopservice.dto.ResponseMessage;
import com.backend.shopservice.model.Order;
import com.backend.shopservice.model.Product;
import com.backend.shopservice.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/shop")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("http://localhost:5173")
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        Product savedProduct = this.shopService.saveProduct(product);
        ResponseMessage<Product> responseMessage = new ResponseMessage<>(savedProduct, "Il prodotto è stato salvato con successo");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
    @GetMapping("/product")
    public ResponseEntity<?> getByCompanyId(@RequestParam(name = "companyId") String id) {
        List<Product> products = this.shopService.getByCompanyId(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/prodcutlist")
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = this.shopService.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestParam(name = "id") String id) {
        this.shopService.deleteProduct(id);
    }

    @PostMapping("/order")
    public ResponseEntity<?> saveOrder(@RequestBody Order order){
        this.shopService.saveOrder(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<?> getByOrdersId(@RequestParam(name = "orderId") String id) {
        List<Order> orders = this.shopService.getAllOrders(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/company_order")
    public ResponseEntity<?> getOrdersByCompanyId(@RequestParam(name= "companyId") String id) {
        List<Order> orders = this.shopService.getOrdersByCompany(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/user_order")
    public ResponseEntity<?> getOrdersByUserId(@RequestParam(name = "userId") String id) {
        List<Order> orders = this.shopService.getOrdersByUser(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/user_order_by_date")
    public ResponseEntity<?> getOrdersByUserIdOrderedByDate(@RequestParam(name = "userId") String id){
        List<Order> orders = this.shopService.getOrdersByUserOrderedByDate(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


}
