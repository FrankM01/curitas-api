package com.frank.curitas.domain.consulta.validaciones;

import com.frank.curitas.domain.ValidacionException;
import com.frank.curitas.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidacionFueraHorarioConsultas implements ValidadorDeConsultas{
    public void validar(DatosReservaConsulta datos){
        var fechaConsulta = datos.fecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntesDeAperturaClinica = fechaConsulta.getHour() < 7;
        var horarioDespuesDeCiererClinica = fechaConsulta.getHour() > 18;
        if(domingo || horarioAntesDeAperturaClinica || horarioDespuesDeCiererClinica) {
            throw new ValidacionException("Horario seleccionado fuerad del h orario de atendimiento de la clinica");
        }

    }
}
