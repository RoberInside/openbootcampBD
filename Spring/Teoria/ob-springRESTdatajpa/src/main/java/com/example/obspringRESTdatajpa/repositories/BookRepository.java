package com.example.obspringRESTdatajpa.repositories;

import com.example.obspringRESTdatajpa.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {



}
