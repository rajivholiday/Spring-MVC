package com.example.pro4_11.service;

import com.example.pro4_11.entity.Banana;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class BananaService  implements GoodsDao<Banana>{
    private  final List<Banana> bananas =  new ArrayList<>();
    @Override
    public void create(Banana banana) {
        bananas.add(banana);

    }

    @Override
    public Optional<Banana> get(int id) {
        for(Banana banana:bananas)
            if(banana.getId() == id){
                return Optional.of(banana);
            }
        return Optional.empty();
    }

    @Override
    public List<Banana> getAll() {
        return null;
    }

    @Override
    public void update(int id, Banana banana) {
        for(Banana b: bananas)
            if(b.getId() == id){
                b.setPrice(banana.getPrice());
                b.setAmount(banana.getAmount());

            }
    }

    @Override
    public void delete(int id) {
        for(Banana b: bananas)
            if(b.getId() == id){
                bananas.remove(b);
                break;
            }
    }
}
