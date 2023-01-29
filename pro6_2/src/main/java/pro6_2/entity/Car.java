package pro6_2.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String brand;
    @Column
    private String color;
    @Column
    private String engineType;
    @Column
    private Integer mileage;

    @ManyToMany(targetEntity = Driver.class, mappedBy = "cars", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<Driver> drivers;


}
