package com.aplicacion.cliente.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Pagos")
public class Pagos {

    private @Id String id;

    private Facturas factura;

    private String estado_pago;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Facturas getFactura() {
        return factura;
    }

    public void setFactura(Facturas factura) {
        this.factura = factura;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }
}
