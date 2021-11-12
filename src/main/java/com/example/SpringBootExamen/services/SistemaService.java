package com.example.SpringBootExamen.services;

import com.example.SpringBootExamen.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SistemaService {

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

    public List<Cliente> getClientes(){
        return clientes;
    }

    public Cliente buscarCliente(String dni){
        return clientes.stream().filter(cliente -> cliente.getDni().equalsIgnoreCase(dni)).findFirst().get();
    }

    public void removeCliente(String dni){
        Optional<Cliente> optionalCliente = Optional.ofNullable(buscarCliente(dni));

        if (optionalCliente.isPresent()){
            clientes.remove(optionalCliente.get());
        }
    }

    public void updateCliente (Cliente cliente){
        removeCliente(cliente.getDni());
        clientes.add(cliente);
    }

}
