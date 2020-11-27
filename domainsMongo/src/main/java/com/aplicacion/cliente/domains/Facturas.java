package com.aplicacion.cliente.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("Facturas")
public class Facturas {

    private @Id String id;

    private String fecha;

    private double cuantia;

    private int forma_pago;

    private Visitas[] visita;

    private Cliente cliente;

    private String estado;

    public Visitas[] getVisita() {
        return visita;
    }

    public void setVisita(Visitas[] visita) {
        this.visita = visita;
    }

    public int getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(int forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado_factura) {
        this.estado = estado_factura;
    }

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
