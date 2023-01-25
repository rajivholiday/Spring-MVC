package pro6_3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Interviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String companyName;

    @ManyToMany(targetEntity = Applicant.class, mappedBy = "interviewers",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Applicant> applicants;

}
