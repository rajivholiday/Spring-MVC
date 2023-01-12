package com.example.pro5_10.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String salary;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "person_medical_card",
            joinColumns =
                    {@JoinColumn(name = "person_id", referencedColumnName = "id", unique = true)},
            inverseJoinColumns =
                    {@JoinColumn(name = "card_id", referencedColumnName = "id", unique = true)})
    MedicalCard medical_card;


}
