package com.frank.curitas.paciente;

import com.frank.curitas.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionPaciente(
        @NotNull Long id,
        String nombre,
        String telefono,
        @Valid DatosDireccion direccion
) {
}
