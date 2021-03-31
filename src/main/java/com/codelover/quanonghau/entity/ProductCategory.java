package com.codelover.quanonghau.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_category")
@Data
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "procategory_code", nullable = false)
    private String proCategoryCode;

    @Column(name = "procategory_name", nullable = false)
    private String proCategoryName;

    @Column(name = "procategory_des", nullable = false)
    private String proCategoryDes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProCategoryCode() {
        return proCategoryCode;
    }

    public void setProCategoryCode(String proCategoryCode) {
        this.proCategoryCode = proCategoryCode;
    }

    public String getProCategoryName() {
        return proCategoryName;
    }

    public void setProCategoryName(String proCategoryName) {
        this.proCategoryName = proCategoryName;
    }

    public String getProCategoryDes() {
        return proCategoryDes;
    }

    public void setProCategoryDes(String proCategoryDes) {
        this.proCategoryDes = proCategoryDes;
    }
}
