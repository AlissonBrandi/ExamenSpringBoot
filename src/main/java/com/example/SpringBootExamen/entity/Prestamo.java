package com.example.SpringBootExamen.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter

public class Prestamo {

    private String fecha;
    private ItemPrestamo item;
    private String echaDevolucion;
    private String estado;
    private String dni;


}
