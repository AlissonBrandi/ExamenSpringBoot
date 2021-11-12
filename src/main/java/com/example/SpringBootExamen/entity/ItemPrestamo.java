package com.example.SpringBootExamen.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class ItemPrestamo {

    private int codigo;
    private String nombre;


    public ItemPrestamo(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public abstract int getDiasDevolucion();


}
