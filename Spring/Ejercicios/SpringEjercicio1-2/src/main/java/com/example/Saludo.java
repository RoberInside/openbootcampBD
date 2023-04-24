package com.example;

import org.springframework.stereotype.Component;

@Component
public class Saludo {

    public void imprimirSaludo() {
        System.out.println("Hola, te saludo!");
    }
}
