package com.example.pro5_9.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.id.factory.internal.IdentityGenerationTypeStrategy;

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

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "c_id", referencedColumnName = "id")
    private Car car;

}
