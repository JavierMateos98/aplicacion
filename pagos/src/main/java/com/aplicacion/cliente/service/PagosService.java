package com.aplicacion.cliente.service;

import com.aplicacion.cliente.domains.ClienteDTO;
import com.aplicacion.cliente.repositories.PagosRepository;
import com.aplicacion.cliente.domains.Facturas;
import com.aplicacion.cliente.domains.Pagos;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    public String recogerFactura(String id){

        Application app = eurekaClient.getApplication("discovery-facturas");

        List<InstanceInfo> lista = app.getInstances();

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = lista.get(0).getHomePageUrl();

        return restTemplate.getForEntity(fooResourceUrl + "/facturas/buscarId/" + id, Facturas.class).getBody().getId();

    }

    public Pagos guardar(Pagos pago){
        pago.setFacturaid(recogerFactura(pago.getFacturaid()));

        return pagoRepository.insert(pago);
    }

    /*
    public List<Pagos> buscarEstado(String estado){
        return pagoRepository.findByEstadopago(estado);
    }

    public List<Pagos> buscarCliente(ClienteDTO cliente){
        return pagoRepository.findByFactura_Cliente(cliente);
    }

    public List<Pagos> buscarClienteEstado(String estado){
        return pagoRepository.findByFactura_Cliente_Estado(estado);
    }

    public List<Pagos> buscarFacturaEstado(String estado){
        return pagoRepository.findByFactura_Estado(estado);
    }

    public List<Pagos> buscarFactura(Facturas factura){
        return pagoRepository.findByFactura(factura);
    }

     */

}
