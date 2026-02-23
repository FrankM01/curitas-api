package com.frank.curitas.medico;

import com.frank.curitas.direccion.DatosDireccion;

public record DatosRegistroMedico(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        DatosDireccion direccion

        ) {
}
