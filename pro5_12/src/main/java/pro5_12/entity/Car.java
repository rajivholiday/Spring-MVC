package pro5_12.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String brand;
    @Column
    private Long production_Year;
    @Column(unique = true, nullable = false)
    private Long carNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "person_car",
            joinColumns = {
                    @JoinColumn(name = "car_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "id")
            })
    private Person person;
}
