package com.example.les_4_1.service;

import com.example.les_4_1.entity.Cat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CatService implements DAO<Cat> {
    private ArrayList<Cat> cats = new ArrayList<>();

    @Override
    public String delete(int id) {
        for (Cat c : cats)
            if (c.getId() == id) {
                cats.remove(c);
            }
        return "Cat was deleted";
    }

    @Override
    public Cat get(int id) {
        for (Cat c : cats)
            if (c.getId() == id) {
                return c;
            }
        return null;
    }

    @Override
    public Cat create(int id, String color, String name, int age) {
        Cat c = fillData(id, color, name, age, new Cat());
        cats.add(c);
        return c;
    }

    @Override
    public Cat update(int id, String color, String name, int age) {
        for (int i = 0; i < cats.size(); i++)
            if (cats.get(i).getId() == id) {
                fillData(id, color, name, age, cats.get(i));
                return cats.get(i);
            }
        return null;
    }

    private Cat fillData(int id, String color, String name, int age, Cat c) {
        c.setId(id);
        c.setColor(color);
        c.setName(name);
        c.setAge(age);
        return c;
    }


}
