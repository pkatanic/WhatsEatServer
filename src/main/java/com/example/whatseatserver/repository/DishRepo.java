package com.example.whatseatserver.repository;


import com.example.whatseatserver.entity.DishEntity;
import org.springframework.data.repository.CrudRepository;

public interface DishRepo extends CrudRepository<DishEntity, Long> {

    DishEntity findByTitle(String title);
}
