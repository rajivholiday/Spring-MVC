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
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Integer birthYear;
    @Column
    private Double salary;

    @ManyToMany(targetEntity = Car.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Car> cars;
}
