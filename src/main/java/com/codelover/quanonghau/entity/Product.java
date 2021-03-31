package com.codelover.quanonghau.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_code", nullable = false, unique = true)
    private String productCode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "number_product", nullable = false)
    private int numberProduct;

    @Column(name = "created_date", nullable = false )
    private String createdDate;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductHistory> history;

    @ManyToOne
    @JoinColumn(name = "procategory_id")
    private ProductCategory productCategory;


}
