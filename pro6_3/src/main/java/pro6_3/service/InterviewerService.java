package pro6_3.service;

import org.springframework.stereotype.Service;
import pro6_3.entity.Interviewer;
import pro6_3.repository.InterviewerRepo;
import pro6_3.dto.InterviewerRequest;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewerService {
    private final InterviewerRepo repo;

    public InterviewerService(InterviewerRepo repo) {
        this.repo = repo;
    }

    public List<Interviewer> getAll() {
        return repo.findAll();
    }

    public Optional<Interviewer> getById(int id) {
        return repo.findById(id);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public Integer create(InterviewerRequest request) {
        return repo.save(fieldSetter(new Interviewer(), request)).getId();
//        Interviewer interviewer_for_db = fieldSetter(new Interviewer(), request);
//        return interviewer_for_db.getId();
    }

    public void update(InterviewerRequest interviewer, int id) {
        repo.save(fieldSetter(getById(id).orElseThrow(), interviewer));
//        Interviewer interviewer_for_db = fieldSetter(getById(id).orElseThrow(), interviewer);
//        repo.save(interviewer_for_db);
    }

    private Interviewer fieldSetter(Interviewer db_interviewer, InterviewerRequest request) {
        db_interviewer.setName(request.name());
        db_interviewer.setSurname(request.surname());
        db_interviewer.setCompanyName(request.companyName());
        db_interviewer.setApplicants(request.applicants());

        return db_interviewer;
    }
}
