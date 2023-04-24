package com.example;

import org.springframework.stereotype.Component;


@Component
public class NotificationService {

    public NotificationService(){

    }
    public void imprimirSaludo() {
        System.out.println("Hola, te saludo!");
    }
}
