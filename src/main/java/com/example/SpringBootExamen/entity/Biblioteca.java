package com.example.SpringBootExamen.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter

@Configuration
@PropertySource("infoBiblioteca.application.properties")
public class Biblioteca {

    @Value("${bliblioteca.nombre}")
    private String nombre;

    @Value("${biblioteca.direccion}")
    private String direccion;



}
