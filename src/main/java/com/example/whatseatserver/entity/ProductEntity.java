package com.example.whatseatserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "product_entity")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategoryEntity product_category;

    @OneToMany(mappedBy = "product")
    private List<RecipeEntity> recipes;
}
