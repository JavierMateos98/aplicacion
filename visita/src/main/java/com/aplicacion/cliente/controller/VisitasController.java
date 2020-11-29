package com.aplicacion.cliente.controller;

import com.aplicacion.cliente.domains.Cliente;
import com.aplicacion.cliente.domains.ClienteDTO;
import com.aplicacion.cliente.domains.Visitas;
import com.aplicacion.cliente.domains.VisitasDTO;
import com.aplicacion.cliente.service.VisitaService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitas")
public class VisitasController {

    @Autowired
    VisitaService visitaService;

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") int id){
        visitaService.eliminar(id);
    }

    @GetMapping("/buscarestado/{estado}")
    public ResponseEntity<?> buscarEstado(@PathVariable("estado") String estado){
        List<Visitas> visitas = visitaService.buscarEstado(estado);

        if(visitas != null){
            return new ResponseEntity<>(visitas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscarcliente/{nombre}")
    public ResponseEntity<?> buscarCliente(@PathVariable("nombre") String nombre){
        Visitas visitas = visitaService.buscarVisitaCliente(nombre);

        VisitasDTO visitaB = new VisitasDTO();

        visitaB.setEstado(visitas.getEstado());
        visitaB.setFecha(visitas.getFecha());
        visitaB.setId(visitas.getId());
        visitaB.setImporte(visitas.getImporte());

        if(visitaB != null){
            return new ResponseEntity<>(visitaB, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar")
    public Visitas actualizarVisita(@RequestBody Visitas visita){
        return visitaService.actualizar(visita);
    }

    @PostMapping("/buscarclientevisita")
    public ResponseEntity<?> buscarClienteVisita(@RequestBody Visitas visita){
        Visitas visitas = visitaService.guardar(visita);

        if(visitas != null){
            return new ResponseEntity<>(visitas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
