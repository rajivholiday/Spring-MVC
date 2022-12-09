package com.example.pro4_12.controller;

import com.example.pro4_12.entity.Book;
import com.example.pro4_12.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/error")
    public ModelAndView handlerEx() {
        log.info("Exception is caught");
        ModelAndView modelAndView = new ModelAndView("sample");
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id) {
        Book b = service.getById(id).orElse(new Book());
        if (Character.isLowerCase(b.getName().charAt(0))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "No such book found");
        }
        return ResponseEntity.ok(b);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Book book) {
        service.create(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Book book) {
        service.update(id, book);
        return new ResponseEntity<>("Book was updated", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>("Book was deleted", HttpStatus.OK);
    }


}
