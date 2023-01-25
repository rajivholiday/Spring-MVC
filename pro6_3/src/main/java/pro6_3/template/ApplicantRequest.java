package pro6_3.template;

import pro6_3.entity.Interviewer;

import java.util.Set;

public record ApplicantRequest(String name, String surname, String education,
                               Integer age, Set<Interviewer> interviewers) {
}
