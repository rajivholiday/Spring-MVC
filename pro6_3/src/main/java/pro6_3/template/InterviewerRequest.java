package pro6_3.template;

import pro6_3.entity.Applicant;

import java.util.Set;

public record InterviewerRequest(String name, String surname, String companyName,
                                 Set<Applicant> applicants) {
}
