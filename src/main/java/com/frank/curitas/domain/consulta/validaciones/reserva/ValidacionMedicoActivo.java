package com.frank.curitas.domain.consulta.validaciones.reserva;

import com.frank.curitas.domain.ValidacionException;
import com.frank.curitas.domain.consulta.DatosReservaConsulta;
import com.frank.curitas.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionMedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository repository;

    public void validar(DatosReservaConsulta datos){

        // eleccion del medico opcional
        if(datos.idMedico() == null){
            return;
        }
        var medicoEstaActivo = repository.findActivoById(datos.idMedico());
        if(!medicoEstaActivo){
            throw new ValidacionException("Consulta no puede ser reservada con medico excluido");
        }
    }
}
