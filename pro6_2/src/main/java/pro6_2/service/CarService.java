package pro6_2.service;

import org.springframework.stereotype.Service;
import pro6_2.entity.Car;
import pro6_2.repository.CarRepo;
import pro6_2.repository.DriverRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepo carRepo;
    private final DriverRepo driverRepo;


    public CarService(CarRepo carRepo, DriverRepo driverRepo) {
        this.carRepo = carRepo;
        this.driverRepo = driverRepo;
    }

    public List<Car> getAll() {
        return carRepo.findAll();
    }

    public Optional<Car> getById(int id) {
        return carRepo.findById(id);
    }

    public void delete(int id) {
        carRepo.deleteById(id);
    }

    public void update(Car car) {
        Car car1 = setField(car);
        carRepo.save(car1);

    }

    private Car setField(Car car) {
        Car car1 = new Car();
        car1.setBrand(car.getBrand());
        car1.setColor(car.getColor());
        car1.setEngineType(car.getEngineType());
        car1.setMileage(car.getMileage());
        return car1;
    }

    public int create(Car car) {
        return carRepo.save(car).getId();
    }
}
