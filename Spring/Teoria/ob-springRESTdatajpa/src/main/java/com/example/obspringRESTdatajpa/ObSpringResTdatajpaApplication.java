package com.example.obspringRESTdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObSpringResTdatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringResTdatajpaApplication.class, args);

		BookRepository bookRep = context.getBean(BookRepository.class);

		//CRUD
		Book book1 = new Book(null, "Homo Deus", "Yuval Noah",450, 29.99, LocalDate.of(2018,12,1),true);
		Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah",450, 19.99, LocalDate.of(2013,12,1),true);

		System.out.println(bookRep.findAll().size());

		bookRep.save(book1);
		bookRep.save(book2);

		System.out.println(bookRep.findAll().size());

		bookRep.deleteById(1L);

		System.out.println(bookRep.findAll().size());
	}

}
