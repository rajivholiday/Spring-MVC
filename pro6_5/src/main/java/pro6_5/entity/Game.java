package pro6_5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String type;

    @ManyToMany(targetEntity = Userr.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Userr> userrs;
}
