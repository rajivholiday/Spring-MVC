package com.example.pro5_9.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String model;
    @Column
    private String production_year;

    @JsonIgnore
    @OneToOne(mappedBy = "car") // car is the name of the table
    private Person person;

}
