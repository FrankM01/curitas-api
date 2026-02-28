package com.frank.curitas.domain.consulta.validaciones.reserva;

import com.frank.curitas.domain.ValidacionException;
import com.frank.curitas.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorConsultaConAnticipacionReserva")
public class ValidacionConsultaConAnticipacion implements ValidadorDeConsultas{
    public void validar(DatosReservaConsulta datos) {
        var fechaConsulta = datos.fecha();
        var ahora = LocalDateTime.now();
        var diferenciaEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();
        if (diferenciaEnMinutos < 30) {
            throw new ValidacionException("Horario seleccionado con menos de 30 minutos de anticipacion");
        }
    }
}
