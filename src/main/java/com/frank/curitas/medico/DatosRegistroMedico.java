package com.frank.curitas.medico;

import com.frank.curitas.direccion.Direccion;

public record DatosRegistroMedico(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        Direccion direccion

        ) {
}
