package com.example.pro5_7.service;

import com.example.pro5_7.entity.Document;
import com.example.pro5_7.repository.DocumentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    private final DocumentRepo repo;

    public DocumentService(DocumentRepo repo) {
        this.repo = repo;
    }


    public int create(Document document) {
        return repo.save(document).getId();
    }

    public List<Document> getAll() {
        return repo.findAll();
    }

    public Optional<Document> getById(int id) {
        return repo.findById(id);
    }

    public void update(Document document) {
        Document document1 = getById(document.getId()).orElseThrow();
        document1.setName(document.getName());
        document1.setNumber(document.getNumber());
        document1.setEmployee(document.getEmployee());
        repo.save(document1);
    }

    public void delete(int id) {
        repo.deleteById(id);

    }
}
