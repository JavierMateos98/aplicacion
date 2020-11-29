package com.aplicacion.cliente.repositories;

import com.aplicacion.cliente.domains.ClienteDTO;
import com.aplicacion.cliente.domains.Facturas;
import com.aplicacion.cliente.domains.Pagos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PagosRepository extends MongoRepository<Pagos, String> {

    /*
    List<Pagos> findByEstadopago(String estado);

    List<Pagos> findByFactura(Facturas facturas);

     */

}
