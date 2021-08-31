package com.example.whatseatserver.repository;


import com.example.whatseatserver.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductEntity, Long> {

    ProductEntity findByTitle(String title);

}
