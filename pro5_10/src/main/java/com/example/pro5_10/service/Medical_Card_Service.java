package com.example.pro5_10.service;

import com.example.pro5_10.entity.Medical_Card;
import com.example.pro5_10.repository.Medical_Card_Repo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Medical_Card_Service {
    private final Medical_Card_Repo repo;


    public Medical_Card_Service(Medical_Card_Repo repo) {
        this.repo = repo;
    }

    public List<Medical_Card> getAll() {
        return repo.findAll();
    }

    public Optional<Medical_Card> getById(int id) {
        return repo.findById(id);
    }

    public int create(Medical_Card medical_card) {
        return repo.save(medical_card).getId();
    }

    public void update(Medical_Card medical_card) {
        Medical_Card md = getById(medical_card.getId()).orElseThrow();
        md.setReg_number(medical_card.getReg_number());
        md.setDoc_number(medical_card.getDoc_number());
        repo.save(md);
    }
    public void delete(int id){
        repo.deleteById(id);
    }

}
