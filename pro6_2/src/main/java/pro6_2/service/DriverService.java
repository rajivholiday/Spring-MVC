package pro6_2.service;

import org.springframework.stereotype.Service;
import pro6_2.entity.Driver;
import pro6_2.template.DriverRequest;
import pro6_2.repository.CarRepo;
import pro6_2.repository.DriverRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepo driverRepo;



    public DriverService(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;

    }

    public List<Driver> getAll() {
        return driverRepo.findAll();
    }

    public Optional<Driver> getById(int id) {
        return driverRepo.findById(id);
    }

    public void delete(int id) {
        driverRepo.deleteById(id);
    }

    public void update(DriverRequest request, int id) { //
        Driver driver1 = getById(id).orElseThrow();
        Driver driver = setField(driver1, request);
//        Driver drive2 = setField(getById(id).orElseThrow(), request); // this alone also works
        driverRepo.save(driver);
    }

    private Driver setField(Driver db_driver, DriverRequest request) {
        db_driver.setName(request.name());
        db_driver.setSurname(request.surname());
        db_driver.setBirthYear(request.birthYear());
        db_driver.setSalary(request.salary());
        db_driver.setCars(request.cars());
        return db_driver;
    }

    public Integer create(DriverRequest driver) {
        Driver newDriver = new Driver();
        Driver newestDriver = setField(newDriver, driver);
//          Driver newestDriver = setField(new Driver(), driver); // this alone also works
        return  driverRepo.save(newestDriver).getId();

    }
}
