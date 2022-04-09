package com.udea.empleados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    private final String[] CONSUMES = new String[]{ "application/json" };
    private final String[] PRODUCES = new String[]{ "application/json" };

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
                .consumes(new HashSet<>(Arrays.asList(CONSUMES)))
                .produces(new HashSet<>(Arrays.asList(PRODUCES))).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private static ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Documentacion API Rest - Laboratorio Spring Boot")
                .description("Laboratorio Spring Boot - Arquitectura de Software")
                .version("1.0")
                .contact(new Contact("Grupo 1 - ArquiSoft", null, "diego.poveda1@udea.edu.co"))
                .build();
    }
}
