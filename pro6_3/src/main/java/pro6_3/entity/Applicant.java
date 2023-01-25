package pro6_3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String education;
    @Column
    private Integer age;

    @ManyToMany(targetEntity = Interviewer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore

    private Set<Interviewer> interviewers;

}
