package com.example.whatseatserver.repository;


import com.example.whatseatserver.entity.DishEntity;
import com.example.whatseatserver.entity.ProductEntity;
import com.example.whatseatserver.entity.RecipeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepo extends CrudRepository<RecipeEntity, Long> {

    List<RecipeEntity> findByProduct(ProductEntity product);
    RecipeEntity findByDish(DishEntity dish);
}
