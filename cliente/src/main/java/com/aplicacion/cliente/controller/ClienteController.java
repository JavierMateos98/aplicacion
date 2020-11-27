package com.aplicacion.cliente.controller;

import com.aplicacion.cliente.service.ClienteService;
import com.aplicacion.cliente.domains.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/buscar/{nombre}")
    public Cliente buscarClientePagos(@PathVariable("nombre") String nombre){
        return clienteService.buscarNombre(nombre);
    }

    @GetMapping("/provincia/{provincia}")
    public ResponseEntity<?> buscarProvincia(@PathVariable("provincia") String provincia){
        List<Cliente> clientes = clienteService.buscarDireccion(provincia);

        if(clientes != null){
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/nuevo")
    public Cliente crear(@RequestBody Cliente cliente){
        return clienteService.guardar(cliente);
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

    @DeleteMapping("/eliminar/{id}")
    public void eliminarClientes(@PathVariable("id") int id){

        clienteService.eliminar(clienteService.listarCliente(id));

    }

}