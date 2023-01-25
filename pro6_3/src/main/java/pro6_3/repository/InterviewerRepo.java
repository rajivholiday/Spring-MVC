package pro6_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro6_3.entity.Interviewer;
@Repository
public interface InterviewerRepo extends JpaRepository<Interviewer, Integer> {
}
