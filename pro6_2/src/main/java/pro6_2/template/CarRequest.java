package pro6_2.template;

import pro6_2.entity.Driver;

import java.util.Set;

public record CarRequest(String brand, String color, String engineType,
                         Integer mileage, Set<Driver> drivers) {
}
