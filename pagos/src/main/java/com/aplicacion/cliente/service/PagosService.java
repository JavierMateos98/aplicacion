package com.aplicacion.cliente.service;

import com.aplicacion.cliente.domains.Cliente;
import com.aplicacion.cliente.repositories.PagosRepository;
import com.aplicacion.cliente.domains.Facturas;
import com.aplicacion.cliente.domains.Pagos;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PagosService {

    @Autowired
    PagosRepository pagoRepository;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    public Facturas prueba(String id){

        Application app = eurekaClient.getApplication("discovery-facturas");

        List<InstanceInfo> lista = app.getInstances();

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = lista.get(0).getHomePageUrl();

        return restTemplate.getForEntity(fooResourceUrl + "/facturas/buscarId/" + id, Facturas.class).getBody();

    }

    public Pagos guardar(Pagos pago){
        pago.setFactura(prueba(pago.getFactura().getId()));

        return pagoRepository.save(pago);
    }

    /*
    public List<Pagos> buscarEstado(String estado){
        return pagoRepository.findByEstado(estado);
    }

     */

    /*
    public List<Pagos> buscarCliente(Cliente cliente){
        return pagoRepository.findByCliente(cliente);
    }

     */

}
