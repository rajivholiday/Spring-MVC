package com.example.pro5_1.service;

import com.example.pro5_1.entity.Azerbaijan;
import com.example.pro5_1.exceptions.CityNotFoundException;
import com.example.pro5_1.exceptions.UserNotCreatedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AzerbaijanService implements DAO<Azerbaijan> {
    private final List<Azerbaijan> az_cities = new ArrayList<>();

    @Override
    public void create(Azerbaijan city) {

        az_cities.add(city);
    }

    @Override
    public List<Azerbaijan> getAll() {
        return az_cities;
    }

    @Override
    public Optional<Azerbaijan> getById(int id) {
        for (Azerbaijan a : az_cities)
            if (a.getId() == id) {
                return Optional.of(a);
            }
        return Optional.empty();
    }

    @Override
    public void update(int id, Azerbaijan city) {
        Azerbaijan a = getById(id).orElseThrow(CityNotFoundException::new);
        a.setCity(city.getCity());
        a.setPopulation(city.getPopulation());
    }

    @Override
    public void delete(int id) {
        Azerbaijan a = getById(id).orElseThrow(CityNotFoundException::new);
        az_cities.remove(a);

    }
}
