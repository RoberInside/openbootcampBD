package org.example;

import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    Calculator cal;

    public GestorFacturas(Calculator calculator) {
        System.out.println("Ejecutando constructor de GestorFacturas");
        this.cal = calculator;
    }
}
