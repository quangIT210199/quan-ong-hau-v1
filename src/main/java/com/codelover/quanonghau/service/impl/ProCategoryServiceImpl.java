package com.codelover.quanonghau.service.impl;

import com.codelover.quanonghau.entity.ProductCategory;
import com.codelover.quanonghau.repository.ProCategoryRepository;
import com.codelover.quanonghau.repository.ProductRepository;
import com.codelover.quanonghau.service.ProCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProCategoryServiceImpl implements ProCategoryService {

    @Autowired
    ProCategoryRepository proCategoryRepository;

    @Override
    public ProductCategory findById(Long id) {
        ProductCategory productCategory = proCategoryRepository.findById(id).orElse(null);

        return productCategory;
    }
}
