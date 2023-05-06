package com.example.obspringRESTdatajpa.controllers;

import com.example.obspringRESTdatajpa.entities.Laptop;
import com.example.obspringRESTdatajpa.repositories.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {

        Optional<Laptop> lp = lpRepository.findById(id);
        if (lp.isPresent()) {
            return ResponseEntity.ok(lpRepository.findById(id).get());
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop lp){
        return ResponseEntity.ok(lpRepository.save(lp));
    }

    @PutMapping("/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop lp){

        if (lpRepository.existsById(lp.getId())) {
            return ResponseEntity.ok(lpRepository.save(lp));
        }
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (lpRepository.existsById(id)) {
            lpRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        if (lpRepository != null) {
            lpRepository.deleteAll();
        }
        return ResponseEntity.noContent().build();
    }


}
