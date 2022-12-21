package com.example.pro5_6.service;

import com.example.pro5_6.entity.Iphone;
import com.example.pro5_6.exceptions.NoSuchPhoneException;
import com.example.pro5_6.repository.IphoneRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IphoneService {
    private final IphoneRepo repo;

    public IphoneService(IphoneRepo repo) {
        this.repo = repo;
    }
    public int create(Iphone iphone) {
        repo.save(iphone);
        return iphone.getId();
    }

    public List<Iphone> getAll() {
        return repo.findAll();
    }

    public Optional<Iphone> getById(int id) {
        return repo.findById(id);
    }

    public void update(Iphone iphone) {
        Iphone iphone1 = getById(iphone.getId()).orElseThrow(NoSuchPhoneException::new);
        iphone1.setColor(iphone.getColor());
        iphone1.setRegNumber(iphone.getRegNumber());
        repo.save(iphone1);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
