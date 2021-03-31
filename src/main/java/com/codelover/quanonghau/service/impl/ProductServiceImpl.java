package com.codelover.quanonghau.service.impl;

import com.codelover.quanonghau.entity.Product;
import com.codelover.quanonghau.repository.ProductRepository;
import com.codelover.quanonghau.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCT_CODE ="SP_";

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        long count = productRepository.count();
        product.setProductCode(PRODUCT_CODE + count);

        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        List<Product> result = productRepository.findAll();

        return result;
    }

    @Override
    public Product findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);

        return product;
    }

    @Override
    public Product findByProductCode(String productCode) {
        Product product = productRepository.findProductByProductCode(productCode);

        return product;
    }

    @Override
    public int count() {
        return (int)productRepository.count();
    }

    @Override
    public List<Product> search(String keyword) {
        return productRepository.search(keyword);
    }
}
