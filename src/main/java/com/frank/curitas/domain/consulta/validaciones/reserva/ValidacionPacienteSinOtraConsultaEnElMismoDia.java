package com.frank.curitas.domain.consulta.validaciones.reserva;

import com.frank.curitas.domain.ValidacionException;
import com.frank.curitas.domain.consulta.ConsultaRepository;
import com.frank.curitas.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionPacienteSinOtraConsultaEnElMismoDia implements ValidadorDeConsultas{


    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos){
        var  primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);
        var pacienteTieneOtraCOnsultaEnElDia = repository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario, ultimoHorario);
        if (pacienteTieneOtraCOnsultaEnElDia){
            throw new ValidacionException("Paciente ya tiene una cita reservada para ese dia");
        }

    }
}
