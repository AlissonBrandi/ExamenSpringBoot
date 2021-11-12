package com.example.SpringBootExamen.entity;

public class CD extends ItemPrestamo{

    public CD(int codigo, String nombre) {
        super(codigo, nombre);
    }

    @Override
    public int getDiasDevolucion() {
        return 0;
    }
}
