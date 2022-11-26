package com.example.pro47.service;

import com.example.pro47.entity.Worker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class WorkerService {
    private final List<Worker> workers = new ArrayList<>();

    public void create(Worker worker) {
        workers.add(worker);
        log.info("Worker was created");

    }

    public List<Worker> getAll() {
        log.info("Getting the list of workers");
        return workers;
    }

    public Worker getById(int id) {
        for (Worker worker : workers)
            if (worker.getId() == id) {
                log.info("Worker with id {} was retrieved", worker.getId());
                return worker;
            }
        return null;
    }

    public void update(int id, Worker worker) {
        for (Worker person : workers)
            if (worker.getId() == id) {
                person.setName(worker.getName());
                person.setSurname(worker.getSurname());
                log.info("Worker was updated");
            }
    }

    public void delete(int id) {
        for (Worker worker : workers)
            if (worker.getId() == id) {
                workers.remove(worker);
                break;
            }
        log.info("Worker was deleted");
    }
}
