package com.aplicacion.cliente.domains;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "Visitas")
public class Visitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha;

    @Column(name = "importe")
    @Digits(integer = 5, fraction = 2)
    @DecimalMin("0.0")
    private double importe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @Column(name = "estado")
    private String estado;

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
