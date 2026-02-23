package com.frank.curitas.direccion;

public record Direccion(
        String calle,
        String numero,
        String complemento,
        String barrio,
        String ciudad,
        String codigo_postal,
        String estado

) {
}
