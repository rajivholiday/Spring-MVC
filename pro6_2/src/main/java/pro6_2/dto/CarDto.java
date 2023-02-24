package pro6_2.dto;

import pro6_2.entity.Driver;

import java.util.Set;

public record CarDto(String brand, String color, String engineType,
                     Integer mileage, Set<Driver> drivers) {
}
