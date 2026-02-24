package com.frank.curitas.domain.paciente;

import com.frank.curitas.domain.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionPaciente(
        @NotNull Long id,
        String nombre,
        String telefono,
        @Valid DatosDireccion direccion
) {
}
