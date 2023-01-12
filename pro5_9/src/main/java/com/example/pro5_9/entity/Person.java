package com.example.pro5_9.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column
    private String name;
    @Column
    private String surname;

    @OneToOne(cascade = {CascadeType.ALL}) // 1st creates sub entity , then super entity
    @JsonIgnore
    @JoinColumn(name = "c_id", referencedColumnName = "id") // c_d = Person entity column, id = reference column items
    private Car car;

}
