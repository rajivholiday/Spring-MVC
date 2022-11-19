package new_projects.les3_12.service;

import new_projects.les3_12.entity.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogService {

    public List<Dog> dogGetAll() {
        List<Dog> dogs = new ArrayList<>();
        Dog dog1 = new Dog();
        dog1.setId(10);
        dog1.setName("Rex");
        Dog dog2 = new Dog();
        dog2.setId(11);
        dog2.setName("Max");
        Dog dog3 = new Dog();
        dog3.setId(14);
        dog3.setName("Bars");
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        return dogs;
    }

    public Dog dogById(int id) {
        for (Dog d : dogGetAll())
            if (d.getId() == id) {
                return d;
            }
        return null;
    }
}
