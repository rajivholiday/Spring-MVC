package com.example.pro5_1.service;

import com.example.pro5_1.entity.Azerbaijan;
import com.example.pro5_1.exceptions.CityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AzerbaijanService implements DAO<Azerbaijan> {
    private final List<Azerbaijan> az = new ArrayList<>();

    @Override
    public void create(Azerbaijan azerbaijan) {
        az.add(azerbaijan);
    }

    @Override
    public List<Azerbaijan> getAll() {
        return az;
    }

    @Override
    public Optional<Azerbaijan> getById(int id) {
        for (Azerbaijan a : az)
            if (a.getId() == id) {
                return Optional.of(a);
            }
        return Optional.empty();
    }

    @Override
    public void update(int id, Azerbaijan az) {
        Azerbaijan a = getById(id).orElseThrow(CityNotFoundException::new);
        a.setCity(az.getCity());
        a.setPopulation(az.getPopulation());
    }

    @Override
    public void delete(int id) {
        Azerbaijan a = getById(id).orElseThrow(CityNotFoundException::new);
        az.remove(a);

    }
}
