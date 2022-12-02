package com.example.pro4_11.service;

import com.example.pro4_11.entity.Apple;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class AppleService implements GoodsDao<Apple>{

    private final List<Apple> apples =  new ArrayList<>();
    @Override
    public void create(Apple apple) {
        apples.add(apple);
    }

    @Override
    public Optional<Apple> get(int id) {
        for(Apple apple:apples)
            if(apple.getId() == id){
                return Optional.of(apple);
            }
        return Optional.empty();
    }

    @Override
    public List<Apple> getAll() {
        return apples;
    }

    @Override
    public void update(int id, Apple apple) {

        for(Apple app: apples)
            if(app.getId() == id){
                app.setPrice(apple.getPrice());
                app.setAmount(apple.getAmount());
            }
    }

    @Override
    public void delete(int id) {
        for(Apple apple: apples)
            if(apple.getId() == id){
                apples.remove(apple);
                break;
            }
    }
}
