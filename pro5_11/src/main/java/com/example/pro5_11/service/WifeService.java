package com.example.pro5_11.service;

import com.example.pro5_11.entity.Wife;
import com.example.pro5_11.exceptions.NoSuchEntityFound;
import com.example.pro5_11.repository.WifeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WifeService {
    private final WifeRepo repo;


    public WifeService(WifeRepo repo) {
        this.repo = repo;
    }


    public List<Wife> getAll() {
        return repo.findAll();
    }

    public Optional<Wife> getById(int id) {
        return repo.findById(id);
    }

    public void update(Wife wife) {
        Wife w = getById(wife.getId()).orElseThrow(NoSuchEntityFound::new);
        w.setName(wife.getName());
        w.setSurname(wife.getSurname());
        w.setPassNumber(wife.getPassNumber());
        w.setIssueYear(wife.getIssueYear());
        repo.save(w);
    }

    public Integer create(Wife wife) {
        return repo.save(wife).getId();

    }
    public  void delete(int id){
        repo.deleteById(id);
    }
}



