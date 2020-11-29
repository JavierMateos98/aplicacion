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

import java.util.ArrayList;
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

        return restTemplate.getForEntity(fooResourceUrl + "facturas/buscarId/" + id, Facturas.class).getBody().getId();

    }

    public Facturas[] listarFacturas(int id){

        Application app = eurekaClient.getApplication("discovery-facturas");

        List<InstanceInfo> lista = app.getInstances();

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = lista.get(0).getHomePageUrl();

        return restTemplate.getForEntity(fooResourceUrl + "facturas/buscarIdPago/" + id, Facturas[].class).getBody();

    }

    public Facturas[] listarFacturasEstado(String estado){

        Application app = eurekaClient.getApplication("discovery-facturas");

        List<InstanceInfo> lista = app.getInstances();

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = lista.get(0).getHomePageUrl();

        return restTemplate.getForEntity(fooResourceUrl + "facturas/buscar/" + estado, Facturas[].class).getBody();

    }

    public int buscarClienteId(String nombre){
        Application app = eurekaClient.getApplication("discovery-cliente");

        List<InstanceInfo> lista = app.getInstances();

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = lista.get(0).getHomePageUrl();

        return restTemplate.getForEntity(fooResourceUrl + "cliente/buscar/" + nombre, ClienteDTO.class).getBody().getId();

    }

    public ClienteDTO[] buscarClienteIdEstado(ClienteDTO cliente){
        Application app = eurekaClient.getApplication("discovery-cliente");

        List<InstanceInfo> lista = app.getInstances();

        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl = lista.get(0).getHomePageUrl();

        return restTemplate.postForEntity(fooResourceUrl + "cliente/buscarestado/", cliente, ClienteDTO[].class).getBody();

    }

    public Pagos guardar(Pagos pago){
        pago.setFacturaid(recogerFactura(pago.getFacturaid()));

        return pagoRepository.insert(pago);
    }

    public List<Pagos> buscarFacturaEstado(String estado){
        Facturas[] facturas = listarFacturasEstado(estado);

        ArrayList<Pagos> pagos = new ArrayList<Pagos>();

        for(Facturas factura: facturas){
            List<Pagos> pago = pagoRepository.findByFacturaid(factura.getId());

            for(Pagos pag: pago){
                pagos.add(pag);
            }
        }

        return pagos;
    }

    public List<Pagos> buscarCliente(String nombre){
        Facturas[] facturas = listarFacturas(buscarClienteId(nombre));

        ArrayList<Pagos> pagos = new ArrayList<Pagos>();

        for(Facturas factura: facturas){
            List<Pagos> pago = pagoRepository.findByFacturaid(factura.getId());

            for(Pagos pag: pago){
                pagos.add(pag);
            }
        }

        return pagos;
    }

    public List<Pagos> buscarEstado(String estado){
        return pagoRepository.findByEstadopago(estado);
    }

    public Pagos buscarPago(String id){
        return pagoRepository.findById(id).get();
    }

    public void eliminar(Pagos pago){
        pagoRepository.delete(pago);
    }

    public List<Pagos> buscarFactura(String factura){
        return pagoRepository.findByFacturaid(factura);
    }

    public List<Pagos> buscarClienteEstado(ClienteDTO estado){
        ClienteDTO[] clientes = buscarClienteIdEstado(estado);

        ArrayList<Pagos> pagos = new ArrayList<Pagos>();

        for(ClienteDTO cliente: clientes){
            Facturas[] facturas = listarFacturas(cliente.getId());
            for(Facturas factura: facturas){
                List<Pagos> pago = pagoRepository.findByFacturaid(factura.getId());
                if(pago != null){
                    for(Pagos pag: pago){
                        pagos.add(pag);
                    }
                }
            }
        }
        return pagos;
    }
}
