package com.example.whatseatserver.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DishRepository {

    private String dishDb;

    public DishRepository(){
        dishDb = "";
    }

    public void save(String str){
        dishDb = str;
    }

    public String getDish(){
        return dishDb;
    }
}
