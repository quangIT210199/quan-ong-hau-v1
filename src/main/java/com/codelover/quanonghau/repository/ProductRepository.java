package com.codelover.quanonghau.repository;

import com.codelover.quanonghau.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductByProductCode(String productCode);
}
