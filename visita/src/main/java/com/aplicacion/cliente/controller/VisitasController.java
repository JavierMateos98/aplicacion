package com.aplicacion.cliente.controller;

import com.aplicacion.cliente.domains.Cliente;
import com.aplicacion.cliente.domains.Visitas;
import com.aplicacion.cliente.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitas")
public class VisitasController {

    @Autowired
    VisitaService visitaService;

    @GetMapping("/buscarestado/{estado}")
    public ResponseEntity<?> buscarEstado(@PathVariable("estado") String estado){
        List<Visitas> visitas = visitaService.buscarEstado(estado);

        if(visitas != null){
            return new ResponseEntity<>(visitas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/buscarcliente")
    public ResponseEntity<?> buscarCliente(@RequestBody Cliente cliente){
        List<Visitas> visitas = visitaService.buscarCliente(cliente);

        if(visitas != null){
            return new ResponseEntity<>(visitas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
