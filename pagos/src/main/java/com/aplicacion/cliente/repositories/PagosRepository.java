package com.aplicacion.cliente.repositories;

import com.aplicacion.cliente.domains.Pagos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PagosRepository extends MongoRepository<Pagos, String> {



}
