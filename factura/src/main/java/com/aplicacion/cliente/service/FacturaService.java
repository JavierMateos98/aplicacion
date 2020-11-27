package com.aplicacion.cliente.service;

import com.aplicacion.cliente.domains.Cliente;
import com.aplicacion.cliente.domains.Visitas;
import com.aplicacion.cliente.repositories.FacturaRepository;
import com.aplicacion.cliente.domains.Facturas;
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

    public Cliente buscarCliente(String nombre){
        Application app = eurekaClient.getApplication("discovery-cliente");

        List<InstanceInfo> lista = app.getInstances();

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = lista.get(0).getHomePageUrl();

        return restTemplate.getForEntity(fooResourceUrl + "cliente/buscar/" + nombre, Cliente.class).getBody();

    }

    public Visitas[] buscarVisita(Cliente cliente){
        Application app = eurekaClient.getApplication("discovery-visitas");

        List<InstanceInfo> lista = app.getInstances();

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = lista.get(0).getHomePageUrl();

        return restTemplate.postForObject(fooResourceUrl + "visitas/buscarcliente", cliente, Visitas[].class);

    }

    public Facturas buscarFactura(String id){
        return facturaRepository.findById(id).get();
    }

    public Facturas guardar(Facturas factura){
        factura.setCliente(buscarCliente(factura.getCliente().getNombre()));

        factura.setVisita(buscarVisita(factura.getCliente()));

        return facturaRepository.insert(factura);
    }

    public List<Facturas> buscarEstado(String estado){
        return facturaRepository.findByEstado(estado);
    }

}
