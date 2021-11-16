package com.example.SpringBootExamen.configuration;

import com.example.SpringBootExamen.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class SistemaConfiguration extends ResponseEntityExceptionHandler {


    //         Exepciones Clientes

    @ExceptionHandler({ ClienteNoExisteException.class })
    protected ResponseEntity<Object> ClienteNoExiste(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "el cliente no esta registrado",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ CamposVaciosException.class })
    protected ResponseEntity<Object> CamposVacios(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "se debe llenar todos los campos",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler({ ClienteRegistradoException.class })
    protected ResponseEntity<Object> ClienteRegistrado(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "el cliente ya esta registrado",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    //         Exepciones Item

    @ExceptionHandler({ ItemRegistradoException.class })
    protected ResponseEntity<Object> ItemRegistrado(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "El item ya esta registrado",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    //         Exepciones  Prestamo



}
