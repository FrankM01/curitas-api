package com.frank.curitas.medico;

import com.frank.curitas.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosActualizacionMedico(
        @NotNull Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}
