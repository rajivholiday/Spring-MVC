package com.example.pro5_6.service;

import com.example.pro5_6.entity.Samsung;
import com.example.pro5_6.exceptions.NoSuchPhoneException;
import com.example.pro5_6.repository.SamsungRepo;
import org.springframework.stereotype.Service;

import java.security.NoSuchProviderException;
import java.util.List;
import java.util.Optional;

@Service
public class SamsungService {
    private final SamsungRepo repo;

    public SamsungService(SamsungRepo repo) {
        this.repo = repo;
    }

    public int create(Samsung samsung) {
        repo.save(samsung);
        return samsung.getId();
    }

    public List<Samsung> getAll() {
        return repo.findAll();
    }

    public Optional<Samsung> getById(int id) {
        return repo.findById(id);
    }

    public void update(Samsung samsung) {
        Samsung samsung1 = getById(samsung.getId()).orElseThrow(NoSuchPhoneException::new);
        samsung1.setColor(samsung.getColor());
        samsung1.setRegNumber(samsung.getRegNumber());
        repo.save(samsung1);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
