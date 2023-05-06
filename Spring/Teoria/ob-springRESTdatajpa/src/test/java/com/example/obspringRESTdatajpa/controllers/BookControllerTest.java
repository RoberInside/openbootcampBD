package com.example.obspringRESTdatajpa.controllers;

import com.example.obspringRESTdatajpa.entities.Book;
import io.swagger.models.Response;
import org.apache.logging.log4j.spi.Provider;
import org.apache.logging.log4j.util.ProviderUtil;
import org.apache.tomcat.util.net.openssl.ciphers.Protocol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import javax.net.ssl.SSLContext;
import java.net.ProtocolFamily;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {


    private TestRestTemplate testRestTemplate; // asigna una url automaticamente siempre que se ejecute
    @Autowired // inyecta un constructor por defecto
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort //inyecta un port automaticamente
    private int port;

    @BeforeEach
    void setUp(){
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void hello() {
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("/hola", String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals("Hola a todos!",response.getBody());
    }

    @Test
    void findAll() {
        ResponseEntity<Book[]> response =
        testRestTemplate.getForEntity("/api/books", Book[].class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());

//        //List<Book> books = Arrays.asList(response.getBody());
//        assertEquals(books,response.getBody());
//        System.out.println(books.size());

    }

    @Test
    void findById() {
        ResponseEntity<Book> response =
                testRestTemplate.getForEntity("/api/books/1", Book.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders(); // hacer set de cabeceras para lo que va a recibir la peticion
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "title": "Libro Test",
                    "author": "Yuval Noah",
                    "pages": 450,
                    "price": 29.99,
                    "releaseDate": "2018-12-01",
                    "online": true
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Book> response =
                testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Book.class);

        Book result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Libro Test", result.getTitle());




    }
}