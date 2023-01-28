package pro6_5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Target;
import java.util.Set;

@Entity
@Getter
@Setter
public class Userr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;

    @ManyToMany(targetEntity = Game.class, mappedBy = "userrs", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private Set<Game> games;

}
