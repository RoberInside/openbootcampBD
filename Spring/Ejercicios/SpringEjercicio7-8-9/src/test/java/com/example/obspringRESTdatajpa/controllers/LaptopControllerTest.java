package com.example.obspringRESTdatajpa.controllers;

import com.example.obspringRESTdatajpa.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {
    @LocalServerPort
    private int port;
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @BeforeEach
    void setUp(){
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/laptops", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
        //assertEquals(List.of(Laptop.class), response.getBody());
    }

    @Test
    void findById(){
        ResponseEntity<Laptop> response =
                testRestTemplate.getForEntity("/laptops/1", Laptop.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());



    }
    @Test
    void create() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "model": "ASUS desde test",
                    "os": "Windows",
                    "cores": 3,
                    "price": 299.95,
                    "fabricationDate": "2019-02-15",
                    "wifi": true
                }                
                """;
        HttpEntity<String> request = new HttpEntity<>(json,headers); // peticion
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/laptops", HttpMethod.POST,request,Laptop.class);

        Laptop result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals(3, result.getCores());

    }

    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "model": "ASUS desde test",
                    "os": "Windows",
                    "cores": 3,
                    "price": 299.95,
                    "fabricationDate": "2019-02-15",
                    "wifi": true
                }                
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers); // peticion
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/laptops", HttpMethod.POST,request,Laptop.class);

        Laptop result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals(3, result.getCores());
    }

    @Test
    void delete() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/laptops/1", Laptop[].class);


        List<Laptop> laptops = Arrays.asList(response.getBody());

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());


    }

    @Test
    void deleteAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/laptops", Laptop[].class);

        List<Laptop> laptops = Arrays.asList(response.getBody());

        assertTrue(laptops.isEmpty());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}