package com.example.springdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hace que se genere el ID de manera aleatoria por la libreria.
    private Long id;
    private String model;
    private String manufacturer;
    private Integer year;

    public Coche (){
    }

    public Coche(Long id, String model, String manufacturer, Integer year) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id = " + id +
                ", model = '" + model + '\'' +
                ", manufacturer = '" + manufacturer + '\'' +
                ", year = " + year +
                '}';
    }
}
