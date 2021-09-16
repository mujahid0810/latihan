package com.latihan1.lat1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
@Data
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
}
