package pro6_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro6_3.entity.Applicant;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, Integer> {
}
