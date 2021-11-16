package com.example.SpringBootExamen.services;

import com.example.SpringBootExamen.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SistemaService {

    @Autowired
    private ModelMapper modelMapper;


    private List<Prestamo> prestamos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<ItemPrestamo> items = new ArrayList<>();




    public void addCliente(Cliente cliente){

        clientes.add(cliente);
    }

    public void addPrestamo(Prestamo prestamo){

        prestamos.add(prestamo);
    }

    public List<Prestamo> getPrestamos(){
        return prestamos;
    }


    public void addItemLibro(Libro libro){
            items.add(libro);
    }
    public void addItemCD(CD cd){
            items.add(cd);
    }

    public List<ItemPrestamo> getItems(){
        return items;
    }

    public Boolean buscarItemBoolean(int codigo) {
        for (ItemPrestamo i : items) {

            if (codigo == i.getCodigo()) {
                return true;
            }
        }
        return false;
    }

    public List<Cliente> getClientes(){
        return clientes;
    }

    public Cliente buscarCliente(String dni){
        for (Cliente c : clientes) {

            if (dni.equals(c.getDni())) {
                return c;
            }
        }
        return null;
    }

    public Boolean buscarClienteBoolean(String dni) {
        for (Cliente c : clientes) {

            if (dni.equals(c.getDni())) {
                return true;
            }
        }
        return false;
    }

        public void removeCliente(String dni){
        Optional<Cliente> optionalCliente = Optional.ofNullable(buscarCliente(dni));
            clientes.remove(optionalCliente.get());

    }

    public void updateCliente (Cliente cliente){
        removeCliente(cliente.getDni());
        clientes.add(cliente);
    }


    //Prestamos



}
