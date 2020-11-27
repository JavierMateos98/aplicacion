package com.aplicacion.cliente.service;

import com.aplicacion.cliente.domains.Cliente;
import com.aplicacion.cliente.domains.Visitas;
import com.aplicacion.cliente.repositories.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitaService {

    @Autowired
    VisitaRepository visitaRepository;

    public Visitas guardar(Visitas visitas){
        return visitaRepository.save(visitas);
    }

    public List<Visitas> buscarEstado(String estado){
        return visitaRepository.findByEstado(estado);
    }

    public Visitas[] buscarCliente(Cliente cliente){
        return visitaRepository.findByCliente(cliente);
    }

}
