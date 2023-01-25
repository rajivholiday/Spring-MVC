package pro6_3.service;

import org.springframework.stereotype.Service;
import pro6_3.entity.Applicant;
import pro6_3.repository.ApplicantRepo;
import pro6_3.template.ApplicantRequest;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {
    private final ApplicantRepo repo;


    public ApplicantService(ApplicantRepo repo) {
        this.repo = repo;
    }

    public List<Applicant> getAll() {
        return repo.findAll();
    }

    public Optional<Applicant> getById(int id) {
        return repo.findById(id);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public Integer create(ApplicantRequest applicant) {
        return fieldSetter(new Applicant(), applicant).getId();
    }

    public void update(ApplicantRequest applicant, int id) {
        repo.save(fieldSetter(getById(id).orElseThrow(), applicant));
    }

    private Applicant fieldSetter(Applicant applicant, ApplicantRequest request) {
        applicant.setName(request.name());
        applicant.setSurname(request.surname());
        applicant.setEducation(request.education());
        applicant.setAge(request.age());
        applicant.setInterviewers(request.interviewers());

        return applicant;
    }
}
