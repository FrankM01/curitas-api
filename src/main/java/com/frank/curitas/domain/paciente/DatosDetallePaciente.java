package com.frank.curitas.domain.paciente;

import com.frank.curitas.domain.direccion.Direccion;

public record DatosDetallePaciente(
        String nombre,
        String email,
        String telefono,
        String documentoIdentidad,
        Direccion direccion
) {
    public DatosDetallePaciente(Paciente paciente) {
        this(
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                paciente.getDocumento_identidad(),
                paciente.getDireccion()
        );
    }
}
