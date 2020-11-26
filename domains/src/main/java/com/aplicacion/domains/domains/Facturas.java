package com.aplicacion.domains.domains;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Facturas")
public class Facturas {

    private @Id String id;

    private String fecha;

    private String cuantia;

    private Cliente cliente;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCuantia() {
        return cuantia;
    }

    public void setCuantia(String cuantia) {
        this.cuantia = cuantia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
