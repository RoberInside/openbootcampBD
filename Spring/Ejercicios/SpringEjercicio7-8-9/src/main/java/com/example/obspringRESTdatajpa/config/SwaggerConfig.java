package com.example.obspringRESTdatajpa.config;

import com.example.obspringRESTdatajpa.controllers.LaptopController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Configuracion Swagger para la generacion de documentacion de la API REST
 *
 * http://localhost:8081/swagger-ui/
 */
@Configuration
public class SwaggerConfig {

    @Bean   //disponible en el contenedor de Beans de spring
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Books API REST",
                "Library api rest docs",
                "1.0",
                "http://google.com",
                new Contact("Roberto", "http://google.com", "loquesea@example.com"),
                "License",
                "http://google.com",
                Collections.emptyList());
    }
}