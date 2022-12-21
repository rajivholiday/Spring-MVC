package com.example.pro5_6.service;

import com.example.pro5_6.entity.Xiaomi;
import com.example.pro5_6.exceptions.NoSuchPhoneException;
import com.example.pro5_6.repository.XiaomiRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XiaomiService {
    private final XiaomiRepo repo;

    public XiaomiService(XiaomiRepo repo) {
        this.repo = repo;
    }
    public int create(Xiaomi xiaomi) {
        repo.save(xiaomi);
        return xiaomi.getId();
    }

    public List<Xiaomi> getAll() {
        return repo.findAll();
    }

    public Optional<Xiaomi> getById(int id) {
        return repo.findById(id);
    }

    public void update(Xiaomi xiaomi) {
        Xiaomi xiaomi1 = getById(xiaomi.getId()).orElseThrow(NoSuchPhoneException::new);
        xiaomi1.setColor(xiaomi.getColor());
        xiaomi1.setRegNumber(xiaomi.getRegNumber());
        repo.save(xiaomi1);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
