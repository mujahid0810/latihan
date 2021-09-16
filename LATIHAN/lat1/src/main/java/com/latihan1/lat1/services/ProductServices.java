package com.latihan1.lat1.services;

import com.latihan1.lat1.entity.Product;
import com.latihan1.lat1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){

        return productRepository.findAll();
    }
}
