package com.example.SpringBootExamen.controller;

import com.example.SpringBootExamen.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.SpringBootExamen.services.SistemaService;

import java.util.List;

@RestController

public class SistemaController {


    @Autowired
    private SistemaService sistemaService;

    @PostMapping("/agregarCliente")
    public void addCliente(@RequestBody Cliente cliente){
        sistemaService.addCliente(cliente);
    }

    @GetMapping("/Clientes")
    public List<Cliente> getClientes(){
        return sistemaService.getClientes();
    }

    @PostMapping("/agregarItemLibro")
    public void addIteamLibro(@RequestBody Libro libro){
        sistemaService.addItemLibro(libro);
    }

    @PostMapping("/agregarItemCD")
    public void addIteamCD(@RequestBody CD cd){
        sistemaService.addItemCD(cd);
    }

    @GetMapping("/Items")
    public List<ItemPrestamo> getItems(){
        return sistemaService.getItems();
    }

    @PostMapping("/agregarPrestamo")
    public void addPrestamo(@RequestBody Prestamo prestamo){
        sistemaService.addPrestamo(prestamo);
    }

    @GetMapping("/Prestamos")
    public List<Prestamo> getPrestamos(){
        return sistemaService.getPrestamos();
    }

    @DeleteMapping("/deletCliente/{dni}")
    public void removeCliente(@PathVariable("dni") String dni){
        sistemaService.removeCliente(dni);
    }

    @PutMapping("/actualizarCliente")
    public void updateCliente(@RequestBody Cliente cliente){
        sistemaService.updateCliente(cliente);
    }


}
