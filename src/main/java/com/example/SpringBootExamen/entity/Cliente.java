package com.example.SpringBootExamen.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Cliente {
    private String nombre;
    private String dni;
    private String domicilio;
    private List<Prestamo> prestamos;


    public Cliente(String nombre, String dni, String domicilio) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;;
    }

    public Cliente() {
    }

    public void addPrestamo(Prestamo p){
        prestamos.add(p);
    }


}

