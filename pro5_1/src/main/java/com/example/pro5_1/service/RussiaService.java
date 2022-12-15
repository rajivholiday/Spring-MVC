package com.example.pro5_1.service;

import com.example.pro5_1.entity.Russia;
import com.example.pro5_1.exceptions.CityNotFoundException;
import com.example.pro5_1.exceptions.CityNotCreatedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RussiaService implements DAO<Russia> {
    private final ArrayList<Russia> ru_cities = new ArrayList<>();

    @Override
    public void create(Russia city) {
        if (city.getId() == 0)
            throw new CityNotCreatedException();
        else
            ru_cities.add(city);
    }

    @Override
    public List<Russia> getAll() {
        return ru_cities;
    }

    @Override
    public Optional<Russia> getById(int id) {
        for (Russia r : ru_cities)
            if (r.getId() == id) {
                return Optional.of(r);
            }
        return Optional.empty();
    }

    @Override
    public void update(int id, Russia russia) {
        Russia r = getById(id).orElseThrow(CityNotFoundException::new);
        r.setCity(russia.getCity());
        r.setPopulation(russia.getPopulation());
    }

    @Override
    public void delete(int id) {
        Russia r = getById(id).orElseThrow(CityNotFoundException::new);
        ru_cities.remove(r);
    }
}
