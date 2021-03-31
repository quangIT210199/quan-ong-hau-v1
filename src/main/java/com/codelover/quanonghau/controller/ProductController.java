package com.codelover.quanonghau.controller;

import com.codelover.quanonghau.entity.Product;
import com.codelover.quanonghau.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* -Chưa tạo lớp DTO
* */

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<?> findAllProduct(){

        List<Product> results = productService.findAll();
        if(results.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping(value = "/products/{id}", produces = "application/json")
    public ResponseEntity<?> getProductById(@PathVariable(name = "id") Long id){
        Product product = productService.findById(id);

        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // add new Product
    @PostMapping(value = "/products", produces = "application/json")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        Product pro = productService.findByProductCode(product.getProductCode());

        if(pro != null){ // sản phẩm đã tồn tại
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        productService.createProduct(pro);
        return new ResponseEntity<>(pro, HttpStatus.OK);
    }

    // Full text search
    @GetMapping(value = "/search", produces = "application/json")
    public ResponseEntity<?> getProductById(@Param(value = "keyword") String keyword){
        List<Product> results = productService.search(keyword);

        if(results.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
