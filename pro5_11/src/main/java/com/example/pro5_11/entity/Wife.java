package com.example.pro5_11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Wife {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String surname;
    @Column(unique = true)
    private int passNumber;
    @Column
    private int issueYear;

    @OneToOne(mappedBy = "wife")
   private Husband husband;


}
