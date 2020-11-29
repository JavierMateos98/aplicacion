package com.aplicacion.cliente.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Pagos")
public class Pagos {

    private @Id String id;

    private String facturaid;

    private double cantidad;

    private String estadopago;

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacturaid() {
        return facturaid;
    }

    public void setFacturaid(String facturaid) {
        this.facturaid = facturaid;
    }

    public String getEstadopago() {
        return estadopago;
    }

    public void setEstadopago(String estadopago) {
        this.estadopago = estadopago;
    }
}
