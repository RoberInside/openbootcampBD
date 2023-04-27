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

    /**
     * buscar un libro en base a su id
     * @param id
     * @return Response entity ok o 404 error not found
      */

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        if (!repository.existsById(id))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.findById(id).get());
    }
    //crear libro en base de datos
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book b) {   //pide un cuerpo a la url
        if (b.getId() != null) // es una creacion
            return ResponseEntity.badRequest().build(); // intenta crear un libro con una id existente
        return ResponseEntity.ok(repository.save(b));
    }
    //actualizar un libro en base de datos
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book b) {
        if (b.getId() == null)// no es una creacion
            return ResponseEntity.noContent().build();

        if (!repository.existsById(b.getId())) { //si no existe, lanza un error de not found
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repository.save(b));
    }
    //borrar un libro en base de datos
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
