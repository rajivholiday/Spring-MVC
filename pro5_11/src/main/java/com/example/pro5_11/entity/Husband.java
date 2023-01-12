package com.example.pro5_11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Husband {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private  String name;
    @Column(unique = true, nullable = false)
    private  String surname;
    @Column(unique = true)
    private  int passNumber;
    @Column
    private  int issueYear;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "marriage_id",
    joinColumns = {@JoinColumn(name = "husband_id", referencedColumnName = "id", unique = true)},
    inverseJoinColumns =
    {@JoinColumn(name = "wife_id", referencedColumnName = "id", unique = true)})

    Wife wife;





}
