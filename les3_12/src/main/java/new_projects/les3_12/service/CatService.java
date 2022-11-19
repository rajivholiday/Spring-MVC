package new_projects.les3_12.service;

import new_projects.les3_12.entity.Cat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {
    public List<Cat> catGetAll() {
        List<Cat> cats = new ArrayList<>();
        Cat cat1 = new Cat();
        cat1.setId(5);
        cat1.setName("Graf");
        Cat cat2 = new Cat();
        cat2.setId(6);
        cat2.setName("Kiki");
        Cat cat3 = new Cat();
        cat3.setId(7);
        cat3.setName("Mimi");
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        return cats;
    }

    public Cat catById(int id) {
        for (Cat c : catGetAll())
            if (c.getId() == id) {
                return c;
            }
        return null;
    }
}
