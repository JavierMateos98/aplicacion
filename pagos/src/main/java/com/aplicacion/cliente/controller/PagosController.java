package com.aplicacion.cliente.controller;

import com.aplicacion.cliente.domains.ClienteDTO;
import com.aplicacion.cliente.domains.Pagos;
import com.aplicacion.cliente.service.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagosController {

    @Autowired
    PagosService pagosService;

    @PostMapping("/guardar")
    public ResponseEntity<?> buscarEstado(@RequestBody Pagos pago){
        Pagos pagoC = pagosService.guardar(pago);

        if(pagoC != null){
            return new ResponseEntity<>(pagoC, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
