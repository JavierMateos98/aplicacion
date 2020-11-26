package com.aplicacion.domains.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Pagos")
public class Pagos {

    private @Id String id;

    private String factura;

    private String estado;
}
