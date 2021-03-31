package com.codelover.quanonghau.service;

import com.codelover.quanonghau.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> findAll();

    Product findById(Long id);

    Product findByProductCode(String productCode);

    int count();
}
