package com.aplicacion.cliente.repositories;

import com.aplicacion.cliente.domains.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClienteRepository extends Repository<Cliente, Integer> {

    Cliente save(Cliente cliente);

    Cliente findById(int id);

    Cliente findByNombre(String nombre);

    List<Cliente> findByDireccion_Provincia(String nombre);

    List<Cliente> findAll();

    void delete(Cliente cliente);

}
