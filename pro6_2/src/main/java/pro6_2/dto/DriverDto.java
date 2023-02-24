package pro6_2.dto;

import pro6_2.entity.Car;

import java.util.Set;

public record DriverDto(String name, String surname, Integer birthYear,
                        Double salary, Set<Car> cars) {
}
