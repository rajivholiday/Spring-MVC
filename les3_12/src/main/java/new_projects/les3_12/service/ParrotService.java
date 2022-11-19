package new_projects.les3_12.service;

import new_projects.les3_12.entity.Parrot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParrotService {

    public List<Parrot> parrotGetAll() {
        List<Parrot> parrots = new ArrayList<>();
        Parrot p1 = new Parrot();
        p1.setId(1);
        p1.setName("Henry");
        Parrot p2 = new Parrot();
        p2.setId(2);
        p2.setName("Dakota");
        Parrot p3 = new Parrot();
        p3.setId(3);
        p3.setName("Lola");
        parrots.add(p1);
        parrots.add(p2);
        parrots.add(p3);
        return parrots;
    }

    public Parrot parrotById(int id) {
        for (Parrot p : parrotGetAll()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
