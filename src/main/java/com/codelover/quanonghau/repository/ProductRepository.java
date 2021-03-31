package com.codelover.quanonghau.repository;

import com.codelover.quanonghau.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductByProductCode(String productCode);

    @Query(value = "SELECT * FROM product WHERE " +
            "MATCH (product_name, product_code) " +
            "AGAINST (?1)", nativeQuery = true)
    List<Product> search(String keyword);
}
