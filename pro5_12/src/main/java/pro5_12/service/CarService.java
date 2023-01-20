package pro5_12.service;

import org.springframework.stereotype.Service;
import pro5_12.entity.Car;
import pro5_12.repository.CarRepo;
import pro5_12.repository.PersonRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepo carRepo;
    private final PersonRepo personRepo;


    public CarService(CarRepo carRepo, PersonRepo personRepo) {
        this.carRepo = carRepo;
        this.personRepo = personRepo;
    }

    public List<Car> getAll() {
        return carRepo.findAll();
    }

    public Optional<Car> getById(Long id) {
        return carRepo.findById(id);
    }

    public void delete(Long id) {
        carRepo.deleteById(id);
    }
    public Long create(Car car){
        return carRepo.save(car).getId();
    }

}
