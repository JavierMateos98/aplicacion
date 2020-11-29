package com.aplicacion.cliente.repositories;

import com.aplicacion.cliente.domains.Pagos;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PagosRepository extends MongoRepository<Pagos, String> {

    List<Pagos> findByEstadopago(String estado);

    List<Pagos> findByFacturaid(String facturaid);

    Optional<Pagos> findById(String id);

}
