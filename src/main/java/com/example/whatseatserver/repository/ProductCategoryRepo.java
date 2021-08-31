package com.example.whatseatserver.repository;


import com.example.whatseatserver.entity.ProductCategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepo extends CrudRepository<ProductCategoryEntity, Long> {

    ProductCategoryEntity findByTitle(String title);
}
