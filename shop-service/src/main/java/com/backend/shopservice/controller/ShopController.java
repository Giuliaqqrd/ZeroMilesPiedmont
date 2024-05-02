package com.backend.shopservice.controller;

import com.backend.shopservice.model.Product;
import com.backend.shopservice.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/shop")
@RequiredArgsConstructor
@Slf4j
public class ShopController {
    private final ShopService shopService;

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        this.shopService.saveProduct(product);
        return new ResponseEntity<>("è stato bello scemooo", HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestParam(name = "id") String id) {
        this.shopService.deleteProduct(id);
    }


}
