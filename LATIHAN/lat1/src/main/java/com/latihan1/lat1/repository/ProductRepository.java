package com.latihan1.lat1.repository;

import com.latihan1.lat1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
