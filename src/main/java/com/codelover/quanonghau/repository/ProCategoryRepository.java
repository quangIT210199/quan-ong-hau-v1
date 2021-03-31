package com.codelover.quanonghau.repository;

import com.codelover.quanonghau.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
