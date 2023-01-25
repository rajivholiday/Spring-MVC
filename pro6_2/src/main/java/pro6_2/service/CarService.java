package pro6_2.service;

import org.springframework.stereotype.Service;
import pro6_2.entity.Car;
import pro6_2.repository.CarRepo;
import pro6_2.repository.DriverRepo;
import pro6_2.template.CarRequest;

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

    public void update(CarRequest request, int id) {
        setField((getById(id).orElseThrow()), request);
    }

    private Car setField(Car car_in_DB, CarRequest request) {
        car_in_DB.setBrand(request.brand());
        car_in_DB.setColor(request.color());
        car_in_DB.setEngineType(request.engineType());
        car_in_DB.setMileage(request.mileage());
        car_in_DB.setDrivers(request.drivers());

        return car_in_DB;
    }

    public int create(CarRequest car) {
//        Car car_for_Db = setField(new Car(), car);
//        return car_for_Db.getId();
        return carRepo.save(setField(new Car(), car)).getId();


    }
}
