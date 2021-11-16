package com.example.SpringBootExamen.controller;

import com.example.SpringBootExamen.entity.*;
import com.example.SpringBootExamen.exception.CamposVaciosException;
import com.example.SpringBootExamen.exception.ClienteNoExisteException;
import com.example.SpringBootExamen.exception.ClienteRegistradoException;
import com.example.SpringBootExamen.exception.ItemRegistradoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import com.example.SpringBootExamen.services.SistemaService;

import java.util.List;
import java.util.Optional;

@RestController
public class SistemaController {


    @Autowired
    private SistemaService sistemaService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Biblioteca biblioteca;


    // INFO BIBLIOTECA

    @GetMapping("/getDatosBiblioteca")
    public String getinfoBiblioteca(){
        return " Biblioteca: " + biblioteca.getNombre() + "\n Con dirección en:  "+ biblioteca.getDireccion();
    }

    // CLIENTES

    @PostMapping("/agregarCliente")
    public void addCliente(@RequestBody Cliente cliente) throws CamposVaciosException, ClienteRegistradoException {
        if (cliente.getDni().equals("") || cliente.getNombre().equals("") || cliente.getDomicilio().equals("") ||
                cliente.getDni().isEmpty() || cliente.getNombre().isEmpty() || cliente.getDomicilio().isEmpty()) {

            throw new CamposVaciosException();

        } else if (sistemaService.buscarClienteBoolean(cliente.getDni()) == true) {
            throw new ClienteRegistradoException();
        } else {
            sistemaService.addCliente(cliente);
        }

    }

    @GetMapping("/Clientes")
    public List<Cliente> getClientes() {
        return sistemaService.getClientes();
    }

    @DeleteMapping("/deletCliente/{dni}")
    public void removeCliente(@PathVariable("dni") String dni) throws ClienteNoExisteException {
        Optional<Cliente> optionalCliente = Optional.ofNullable(sistemaService.buscarCliente(dni));

        if (optionalCliente.isPresent()) {
            sistemaService.removeCliente(dni);

        } else {
            throw new ClienteNoExisteException();
        }
    }

    @PutMapping("/actualizarCliente")
    public void updateCliente(@RequestBody Cliente cliente) throws CamposVaciosException, ClienteRegistradoException {
        if (cliente.getDni().equals("") || cliente.getNombre().equals("") || cliente.getDomicilio().equals("") ||
                cliente.getDni().isEmpty() || cliente.getNombre().isEmpty() || cliente.getDomicilio().isEmpty()) {

            throw new CamposVaciosException();

        } else {
            sistemaService.updateCliente(cliente);
        }
    }


    // ITEM

    @PostMapping("/agregarItemLibro")
    public void addIteamLibro(@RequestBody Libro libro) throws ItemRegistradoException {

        if (sistemaService.buscarItemBoolean(libro.getCodigo()) == true){
            throw new ItemRegistradoException();
        }else{
            sistemaService.addItemLibro(libro);
        }

    }

    @PostMapping("/agregarItemCD")
    public void addIteamCD(@RequestBody CD cd) throws ItemRegistradoException {
        if (sistemaService.buscarItemBoolean(cd.getCodigo()) == true){
            throw new ItemRegistradoException();
        }else {
            sistemaService.addItemCD(cd);
        }
    }

    @GetMapping("/Items")
    public List<ItemPrestamo> getItems() {
        return sistemaService.getItems();
    }

    // PRESTAMO

    @PostMapping("/agregarPrestamo")
    public void addPrestamo(@RequestBody Prestamo prestamo) {


        sistemaService.addPrestamo(prestamo);
    }


    @GetMapping("/Prestamos")
    public List<Prestamo> getPrestamos() {
        return sistemaService.getPrestamos();
    }


}
