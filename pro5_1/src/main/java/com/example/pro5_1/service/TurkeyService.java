package com.example.pro5_1.service;

import com.example.pro5_1.entity.Turkey;
import com.example.pro5_1.exceptions.CityNotFoundException;
import com.example.pro5_1.exceptions.CityNotCreatedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurkeyService implements DAO<Turkey> {
    private final ArrayList<Turkey> tr_cities = new ArrayList<>();

    @Override
    public void create(Turkey city) {
        if (city.getId() == 0)
            throw new CityNotCreatedException();
        else
            tr_cities.add(city);
    }

    @Override
    public List<Turkey> getAll() {
        return tr_cities;
    }

    @Override
    public Optional<Turkey> getById(int id) {
        for (Turkey t : tr_cities)
            if (t.getId() == id) {
                return Optional.of(t);
            }
        return Optional.empty();
    }

    @Override
    public void update(int id, Turkey turkey) {
        Turkey t = getById(id).orElseThrow(CityNotCreatedException::new);
        t.setCity(turkey.getCity());
        t.setPopulation(turkey.getPopulation());

    }

    @Override
    public void delete(int id) {
        Turkey t = getById(id).orElseThrow(CityNotFoundException::new);
        tr_cities.remove(t);

    }
}
