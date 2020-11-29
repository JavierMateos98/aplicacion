package com.aplicacion.cliente.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Facturas")
public class Facturas {

    private @Id String id;

    private String fecha;

    private double cuantia;

    private int forma_pago;

    private LineaFactura lineaFactura;

    private int clienteid;

    private String estado;

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

    public double getCuantia() {
        return cuantia;
    }

    public void setCuantia(double cuantia) {
        this.cuantia = cuantia;
    }

    public int getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(int forma_pago) {
        this.forma_pago = forma_pago;
    }

    public LineaFactura getLineaFactura() {
        return lineaFactura;
    }

    public void setLineaFactura(LineaFactura lineaFactura) {
        this.lineaFactura = lineaFactura;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
