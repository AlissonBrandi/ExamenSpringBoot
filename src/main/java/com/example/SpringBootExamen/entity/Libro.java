package com.example.SpringBootExamen.entity;

public class Libro extends ItemPrestamo{

    public Libro(int codigo, String nombre) {
        super(codigo, nombre);
    }

    @Override
    public int getDiasDevolucion() {
        return 0;
    }
}
