package com.aplicacion.cliente.service;

import com.aplicacion.cliente.domains.*;
import com.aplicacion.cliente.repositories.FacturaRepository;
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
public class FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    public int buscarCliente(String nombre){
        Application app = eurekaClient.getApplication("discovery-cliente");

        List<InstanceInfo> lista = app.getInstances();

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = lista.get(0).getHomePageUrl();

        return restTemplate.getForEntity(fooResourceUrl + "cliente/buscar/" + nombre, ClienteDTO.class).getBody().getId();

    }

    public VisitasDTO buscarVisita(String cliente){
        Application app = eurekaClient.getApplication("discovery-visitas");

        List<InstanceInfo> lista = app.getInstances();

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = lista.get(0).getHomePageUrl();

        return restTemplate.getForObject(fooResourceUrl + "visitas/buscarcliente/" + cliente, VisitasDTO.class);

    }

    public Facturas buscarFactura(String id){
        return facturaRepository.findById(id).get();
    }

    public Facturas guardar(Facturas factura, String nombre){
        factura.setClienteid(buscarCliente(nombre));

        LineaFactura lineaFactura = new LineaFactura();

        VisitasDTO visita = buscarVisita(nombre);

        lineaFactura.setId(visita.getId());
        lineaFactura.setEstado(visita.getEstado());
        lineaFactura.setFecha(visita.getFecha().toString());
        lineaFactura.setImporte(visita.getImporte());

        factura.setLineaFactura(lineaFactura);

        return facturaRepository.insert(factura);
    }

    public List<Facturas> buscarEstado(String estado){
        return facturaRepository.findByEstado(estado);
    }

    public List<Facturas> buscarClienteFact(String nombre){
        return facturaRepository.findByClienteid(buscarCliente(nombre));
    }

    public List<Facturas> buscarImporte(Double importe){
        return facturaRepository.findByCuantia(importe);
    }

}
