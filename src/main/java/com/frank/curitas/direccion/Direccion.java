package com.frank.curitas.direccion;

import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String barrio;
    private String ciudad;
    private String codigo_postal;
    private String estado;
}
