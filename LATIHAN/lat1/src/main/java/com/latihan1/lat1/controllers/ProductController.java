package com.latihan1.lat1.controllers;

import com.latihan1.lat1.entity.Product;
import com.latihan1.lat1.repository.ProductRepository;
import com.latihan1.lat1.services.ProductExcelExporter;
import com.latihan1.lat1.services.ProductServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllUser(){
        List<Product> result = productServices.listAll();
        if(result==null || result.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/product/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=products.xlsx";

        response.setHeader(headerKey, headerValue);

        List<Product> listProduct = productServices.listAll();

        ProductExcelExporter excelExporter = new ProductExcelExporter(listProduct);
        excelExporter.export(response);
    }
}
