package com.frank.curitas.domain.consulta.validaciones.reserva;

import com.frank.curitas.domain.ValidacionException;
import com.frank.curitas.domain.consulta.DatosReservaConsulta;
import com.frank.curitas.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionPacienteActivo implements ValidadorDeConsultas {

    @Autowired
    private PacienteRepository repository;

    public void validar(DatosReservaConsulta datos){
        var pacienteEstadoActivo = repository.findActivoById(datos.idPaciente());
        if(!pacienteEstadoActivo){
            throw new ValidacionException("Consulta no puede ser resevada con paciente excluido");
        }
    }
}
