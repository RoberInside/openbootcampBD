package com.example.obspringRESTdatajpa.controllers;

import com.example.obspringRESTdatajpa.entities.Laptop;
import com.example.obspringRESTdatajpa.repositories.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    private LaptopRepository lpRepository;

    public LaptopController(LaptopRepository repository) {
        this.lpRepository = repository;
    }

    @GetMapping("/laptops")
    public List<Laptop> findAll() {
       return lpRepository.findAll();
    }

    @PostMapping("/laptops")
    public void create(@RequestBody Laptop lp){
        lpRepository.save(lp);
    }


}
