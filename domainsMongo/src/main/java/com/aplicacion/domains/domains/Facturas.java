package com.aplicacion.domains.domains;

import com.aplicacion.cliente.domains.Cliente;
import com.aplicacion.cliente.domains.Visitas;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Facturas")
public class Facturas {

    private @Id String id;

    private String fecha;

    private String cuantia;

    private int forma_pago;

    private Visitas visita;

    private Cliente cliente;

    private String estado_factura;

    public int getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(int forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getEstado_factura() {
        return estado_factura;
    }

    public void setEstado_factura(String estado_factura) {
        this.estado_factura = estado_factura;
    }

    public Visitas getVisita() {
        return visita;
    }

    public void setVisita(Visitas visita) {
        this.visita = visita;
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
