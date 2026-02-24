package com.frank.curitas.domain.medico;

import com.frank.curitas.domain.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionMedico(
        @NotNull Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}
