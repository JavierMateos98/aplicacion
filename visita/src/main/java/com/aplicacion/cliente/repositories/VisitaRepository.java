package com.aplicacion.cliente.repositories;

import com.aplicacion.cliente.domains.Cliente;
import com.aplicacion.cliente.domains.Visitas;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface VisitaRepository extends Repository<Visitas, Integer> {

    Visitas save(Visitas visitas);

    Visitas findById(int id);

    Visitas[] findByCliente(Cliente cliente);

    List<Visitas> findByEstado(String estado);

}
