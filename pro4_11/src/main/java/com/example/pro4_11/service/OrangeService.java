package com.example.pro4_11.service;

import com.example.pro4_11.entity.Orange;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class OrangeService implements GoodsDao<Orange> {
    private final List<Orange> oranges = new ArrayList<>();
    @Override
    public void create(Orange orange) {
        oranges.add(orange);
    }

    @Override
    public Optional<Orange> get(int id) {
        for(Orange orange: oranges)
            if(orange.getId() == id){
                return Optional.of(orange);
            }
        return Optional.empty();
    }

    @Override
    public List<Orange> getAll() {
       return oranges;
    }

    @Override
    public void update(int id, Orange orange) {
        for(Orange org: oranges)
            if(org.getId() == id){
                org.setPrice(orange.getPrice());
                org.setAmount(orange.getAmount());
            }

    }

    @Override
    public void delete(int id) {
        for(Orange orange: oranges)
            if(orange.getId() == id){
                oranges.remove(orange);
                break;
            }

    }
}
