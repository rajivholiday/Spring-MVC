package pro6_4.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pro6_4.dto.UserrLogin;
import pro6_4.dto.UserrRequest;
import pro6_4.entity.Userr;
import pro6_4.repository.UserrRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserrService {
    private final UserrRepo repo;

    public UserrService(UserrRepo repo) {
        this.repo = repo;
    }

    public List<Userr> getAll() {
        return repo.findAll();
    }

    public Optional<Userr> getById(Integer id) {
        return repo.findById(id);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public Integer create_registration(UserrRequest request) {
        return repo.save(fieldSetter(request, new Userr())).getId();
    }

    public void update(UserrRequest request, Integer id) {
        repo.save(fieldSetter(request, getById(id).orElseThrow()));
    }

    private Userr fieldSetter(UserrRequest request, Userr db_userr) {
        db_userr.setUsername(request.username());
        db_userr.setPassword(cryptPassword(request.password()));
        db_userr.setName(request.name());
        db_userr.setSurname(request.surname());
        return db_userr;
    }

    private String cryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public Integer login(UserrLogin userrLogin) {
        Userr userr = repo.findByUsername(userrLogin.username()).orElseThrow();
        return BCrypt.checkpw(userrLogin.password(), userr.getPassword()) ? userr.getId() : null;
    }
}
