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

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPago(@PathVariable("id") String id){
        pagosService.eliminar(pagosService.buscarPago(id));
    }

    @GetMapping("listarFacturasCliente/{cliente}")
    public ResponseEntity<?> buscarPagosCliente(@PathVariable("cliente") String nombre){
        List<Pagos> pagos = pagosService.buscarCliente(nombre);

        if(pagos != null){
            return new ResponseEntity<>(pagos, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("buscarestado/{estado}")
    public ResponseEntity<?> buscarEstado(@PathVariable("estado") String estado){
        List<Pagos> pagos = pagosService.buscarEstado(estado);

        if(pagos != null){
            return new ResponseEntity<>(pagos, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("buscarfactura/{id}")
    public ResponseEntity<?> buscarFactura(@PathVariable("id") String id){
        List<Pagos> pagos = pagosService.buscarFactura(id);

        if(pagos != null){
            return new ResponseEntity<>(pagos, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("buscarEstadoCliente")
    public ResponseEntity<?> buscarEstadoCliente(@RequestBody ClienteDTO cliente){
        List<Pagos> pagos = pagosService.buscarClienteEstado(cliente);

        if(pagos != null){
            return new ResponseEntity<>(pagos, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("buscarEstadoFactura/{estado}")
    public ResponseEntity<?> buscarEstadoFactura(@PathVariable("estado") String estado){
        List<Pagos> pagos = pagosService.buscarFacturaEstado(estado);

        if(pagos != null){
            return new ResponseEntity<>(pagos, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
