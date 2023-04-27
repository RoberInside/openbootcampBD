package com.example.obspringRESTdatajpa.controllers;

import com.example.obspringRESTdatajpa.entities.Book;
import com.example.obspringRESTdatajpa.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        if (repository.findById(id).isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.findById(id).get());
    }
    //crear libro en base de datos
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book b) {   //pide un cuerpo a la url

        for (Long i = 0L; i < repository.count(); i++) {
            if (repository.getReferenceById(i).getId().equals(b.getId())) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.ok(repository.save(b));
    }
    //actualizar un libro en base de datos
    @PutMapping("/api/books/update/{id}")
    public Book update(@PathVariable Long id,@RequestBody Book b) {
        b.setId(id);
        return b;
    }
    //borrar un libro en base de datos
    @DeleteMapping("/api/books/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
