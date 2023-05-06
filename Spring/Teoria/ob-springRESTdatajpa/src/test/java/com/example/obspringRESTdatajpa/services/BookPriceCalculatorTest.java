package com.example.obspringRESTdatajpa.services;

import com.example.obspringRESTdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {


    @Test
    void calculatePrice() {
        Book book = new Book(1L,"El señor de los anillos", "autor", 1000, 49.99, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();
        double price = calculator.calculatePrice(book);

        System.out.println(price);

        assertTrue(price > 0);
        assertEquals(57.980000000000004, price);
    }
}