package com.example.pro5_11.service;

import com.example.pro5_11.entity.Husband;
import com.example.pro5_11.exceptions.NoSuchEntityFound;
import com.example.pro5_11.repository.HusbandRepo;
import com.example.pro5_11.repository.WifeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HusbandService {
    private final HusbandRepo repo;
    private final WifeRepo wifeRepo;


    public HusbandService(HusbandRepo repo, WifeRepo wifeRepo) {
        this.repo = repo;
        this.wifeRepo = wifeRepo;
    }

    public List<Husband> getAll() {
        return repo.findAll();
    }

    public Optional<Husband> getById(int id) {
        return repo.findById(id);
    }

    public void update(Husband husband) {
        Husband h = getById(husband.getId()).orElseThrow(NoSuchEntityFound::new);
        h.setName(husband.getName());
        h.setSurname(husband.getSurname());
        h.setPassNumber(husband.getPassNumber());
        h.setIssueYear(husband.getIssueYear());
        repo.save(h);
    }

    public Integer createCommon(Husband husband) {
        Husband h = new Husband();
        h.setName(husband.getName());
        h.setSurname(husband.getSurname());
        h.setPassNumber(husband.getPassNumber());
        h.setIssueYear(husband.getIssueYear());

        if (husband.getWife() != null && husband.getWife().getId() != null)
            h.setWife(wifeRepo.findById(husband.getWife().getId()).orElseThrow(NoSuchEntityFound::new));
        else
            h.setWife(husband.getWife());
        return repo.save(h).getId();
    }
    public  void delete(int id){
        repo.deleteById(id);
    }
}
