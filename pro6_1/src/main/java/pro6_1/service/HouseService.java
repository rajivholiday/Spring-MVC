package pro6_1.service;

import org.springframework.stereotype.Service;
import pro6_1.entity.House;
import pro6_1.entity.Person;
import pro6_1.repository.HouseRepo;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    private final HouseRepo repo;


    public HouseService(HouseRepo repo) {
        this.repo = repo;
    }

    public List<House> getAll() {
        return repo.findAll();
    }

    public Optional<House> getById(int id) {
        return repo.findById(id);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    private House setField(House house) {
        house.setAddress(house.getAddress());
        house.setHouseNumber(house.getHouseNumber());
        house.setPerson(house.getPerson());
        return house;
    }

    public Integer createOrUpdate(House house) {
        return repo.save(house.getId() != null ? setField(getById(house.getId()).orElseThrow()) : house).getId();


    }

}
