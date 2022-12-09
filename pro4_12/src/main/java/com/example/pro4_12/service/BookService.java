package com.example.pro4_12.service;

import com.example.pro4_12.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final ArrayList<Book> library = new ArrayList<Book>();

    public void create(Book book) {
        library.add(book);
    }

    public Optional<Book> getById(int id) {
        for (Book b : library)
            if (b.getId() == id) {
                return Optional.of(b);
            }
        return Optional.empty();
    }

    public List<Book> getAll() {
        return library;
    }

    public void update(int id, Book book) {
        for (Book b : library)
            if (b.getId() == id) {
                b.setAuthor(book.getAuthor());
                b.setName(book.getName());
                b.setPublishYear(book.getPublishYear());
            }
    }

    public void delete(int id) {
        for (Book b : library)
            if (b.getId() == id) {
                library.remove(b);
                break;
            }
    }

}

