package com.aplicacion.cliente.controller;

import com.aplicacion.cliente.domains.Cliente;
import com.aplicacion.cliente.service.FacturaService;
import com.aplicacion.cliente.domains.Facturas;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/buscar/{estado}")
    public ResponseEntity<?> buscarEstado(@PathVariable("estado") String estado){
        List<Facturas> facturas = facturaService.buscarEstado(estado);

        if(facturas != null){
            return new ResponseEntity<>(facturas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<?> buscarFactura(@PathVariable("id") String id){
        Facturas facturas = facturaService.buscarFactura(id);

        if(facturas != null){
            return new ResponseEntity<>(facturas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarFactura(@RequestBody Facturas factura){
        Facturas fact = facturaService.guardar(factura);

        if(fact != null){
            return new ResponseEntity<>(fact, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    /*
    @PostMapping("/buscarcliente")
    public ResponseEntity<?> buscarCliente(@RequestBody Cliente cliente){
        List<Facturas> facturas = facturaService.buscarCliente(cliente);

        if(facturas != null){
            return new ResponseEntity<>(facturas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     */

}
