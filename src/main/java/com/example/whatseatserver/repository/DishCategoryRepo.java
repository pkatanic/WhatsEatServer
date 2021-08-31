package com.example.whatseatserver.repository;


import com.example.whatseatserver.entity.DishCategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface DishCategoryRepo extends CrudRepository<DishCategoryEntity, Long> {

    DishCategoryEntity findByTitle(String title);
}
