package com.backend.shopservice.service;

import com.backend.shopservice.model.Product;
import com.backend.shopservice.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public void saveProduct(Product product){
        this.shopRepository.save(product);
    }
    public void deleteProduct(String id){
        this.shopRepository.deleteById(id);
    }


}
