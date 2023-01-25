package pro6_2.template;

import pro6_2.entity.Car;

import java.util.Set;

public record DriverRequest(Integer id, String name, String surname, Integer birthYear,
                            Double salary, Set<Car> cars) {
}
