package com.example.pro5_10.service;

import com.example.pro5_10.entity.MedicalCard;
import com.example.pro5_10.repository.MedicalCardRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalCardService {
    private final MedicalCardRepo repo;


    public MedicalCardService(MedicalCardRepo repo) {
        this.repo = repo;
    }

    public List<MedicalCard> getAll() {
        return repo.findAll();
    }

    public Optional<MedicalCard> getById(int id) {
        return repo.findById(id);
    }

    public int create(MedicalCard medical_card) {
        return repo.save(medical_card).getId();
    }

    public void update(MedicalCard medical_card) {
        MedicalCard md = getById(medical_card.getId()).orElseThrow();
        md.setReg_number(medical_card.getReg_number());
        md.setDoc_number(medical_card.getDoc_number());
        repo.save(md);
    }
    public void delete(int id){
        repo.deleteById(id);
    }

}
