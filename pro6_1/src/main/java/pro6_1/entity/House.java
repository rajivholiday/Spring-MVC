package pro6_1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private  String address;
    @Column
    private Integer houseNumber;


    @ManyToOne
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private Person person;



}
