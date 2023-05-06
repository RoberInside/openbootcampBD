package com.example.obspringRESTdatajpa.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "books") // cambiar nombre en base de datos.
public class Laptop {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String os;
    private Integer cores;
    private Double price;
    private LocalDate fabricationDate;
    private Boolean wifi;

    public Laptop(){

    }

    public Laptop(Long id, String model, String os, Integer cores, Double price, LocalDate fabricationDate, Boolean wifi) {
        this.id = id;
        this.model = model;
        this.os = os;
        this.cores = cores;
        this.price = price;
        this.fabricationDate = fabricationDate;
        this.wifi = wifi;
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

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(LocalDate fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", os='" + os + '\'' +
                ", cores=" + cores +
                ", price=" + price +
                ", fabricationDate=" + fabricationDate +
                ", wifi=" + wifi +
                '}';
    }
}
