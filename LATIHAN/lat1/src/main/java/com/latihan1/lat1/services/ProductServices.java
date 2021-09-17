package com.latihan1.lat1.services;

import com.latihan1.lat1.entity.Product;
import com.latihan1.lat1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(@RequestParam Long id){
        return productRepository.findById(id);
    }
}
