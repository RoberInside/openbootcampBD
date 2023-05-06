package com.example.obspringRESTdatajpa;

import com.example.obspringRESTdatajpa.entities.Laptop;
import com.example.obspringRESTdatajpa.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication

public class ObSpringResTdatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringResTdatajpaApplication.class, args);

		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop lp1 = new Laptop(null,"ASUS","Windows",3,299.95, LocalDate.of(2019,02,15),true);
		Laptop lp2 = new Laptop(null,"Alienware","Windows",4,499.95, LocalDate.of(2021,02,15),true);

		laptopRepository.save(lp1);
		laptopRepository.save(lp2);



	}

}
