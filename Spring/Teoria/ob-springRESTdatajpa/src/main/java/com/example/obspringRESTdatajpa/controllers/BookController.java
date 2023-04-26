package com.example.obspringRESTdatajpa.controllers;

import com.example.obspringRESTdatajpa.entities.Book;
import com.example.obspringRESTdatajpa.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    //CRUD Book
    //buscar todos los libros

    /**
     * http://localhost:8080/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll() {
       return repository.findAll();
    }

    // buscar un libro en base a su id
    public Book findById(Long id) {
        return repository.findById(id).get();
    }
    //crear libro en base de datos
    public void create() {
        Book b = new Book();
        for (Long i = 0L; i < repository.count(); i++) {
            if (repository.getReferenceById(i).getId() == b.getId()) {
                return;
            }
        }
        repository.save(b);
    }
    //actualizar un libro en base de datos

    //borrar un libro en base de datos

}
