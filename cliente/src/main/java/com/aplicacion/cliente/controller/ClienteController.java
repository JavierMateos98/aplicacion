package com.aplicacion.cliente.controller;

import com.aplicacion.cliente.service.ClienteService;
import com.aplicacion.cliente.domains.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/provincia/{provincia}")
    public ResponseEntity<?> buscarProvincia(@PathVariable("provincia") String provincia){
        List<Cliente> clientes = clienteService.buscarDireccion(provincia);

        if(clientes != null){
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarClientes(){

        List<Cliente> clientes = clienteService.listarClientes();

        if(clientes != null){
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

}