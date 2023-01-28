package pro6_5.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pro6_5.dto.UserLogin;
import pro6_5.dto.UserrRequest;
import pro6_5.entity.Userr;
import pro6_5.exceptions.NotAuthorized;
import pro6_5.exceptions.UserNotFound;
import pro6_5.repository.UserrRepo;

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

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public Integer create_registration(UserrRequest request) {
        return repo.save(fieldSetter(request, new Userr())).getId();
    }

    public void update(UserrRequest request, Integer id) {
        fieldSetter(request, getById(id).orElseThrow(UserNotFound::new));
    }

    private String cryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public Integer login(UserLogin login) {
        Userr user = repo.findByUsername(login.username()).orElseThrow(NotAuthorized::new);
        if (!BCrypt.checkpw(login.password(), user.getPassword())) {
            throw new NotAuthorized();


//        return BCrypt.checkpw(login.password(), user.getPassword()) ? user.getId() : null;
        }
        return user.getId();
    }

    private Userr fieldSetter(UserrRequest request, Userr db_user) {
        db_user.setUsername(request.username());
        db_user.setPassword(cryptPassword(request.password()));
        db_user.setName(request.name());
        db_user.setSurname(request.surname());
        db_user.setGames(request.games());
        return db_user;
    }
}
