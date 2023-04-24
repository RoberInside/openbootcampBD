package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");


        Calculator cal = ((Calculator) context.getBean("calculator"));

        System.out.println(cal.holaMundo());


        GestorFacturas gf = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gf.cal.holaMundo());
    }
}