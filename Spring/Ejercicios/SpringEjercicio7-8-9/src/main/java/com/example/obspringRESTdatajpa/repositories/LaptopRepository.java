package com.example.obspringRESTdatajpa.repositories;

import com.example.obspringRESTdatajpa.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {



}
