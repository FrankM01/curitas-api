package com.frank.curitas.domain.consulta.validaciones.cancelamiento;

import com.frank.curitas.domain.ValidacionException;
import com.frank.curitas.domain.consulta.ConsultaRepository;
import com.frank.curitas.domain.consulta.DatosCancelamientoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorConsultaConAnticipacionCancelamiento")
public class ValidacionConsultaConAnticipacion implements ValidacionCancelamientoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DatosCancelamientoConsulta datos) {
        var consulta = repository.getReferenceById(datos.idConsulta());
        var ahora = LocalDateTime.now();
        var diferenciaEnHoras = Duration.between(ahora, consulta.getFecha()).toHours();

        if(diferenciaEnHoras < 24){
            throw new ValidacionException("La consulta solo puede ser cancelada con anticipacion minima de 24 horas!");
        }

    }
}
