package com.frank.curitas.domain.consulta;

import com.frank.curitas.domain.ValidacionException;
import com.frank.curitas.domain.consulta.validaciones.cancelamiento.ValidacionCancelamientoDeConsulta;
import com.frank.curitas.domain.consulta.validaciones.reserva.ValidadorDeConsultas;
import com.frank.curitas.domain.medico.Medico;
import com.frank.curitas.domain.medico.MedicoRepository;
import com.frank.curitas.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaConsultas {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidacionCancelamientoDeConsulta> validadoresCancelamiento;

    @Autowired
    private List<ValidadorDeConsultas> validadores;

    public DatosDetalleConsulta reservar(DatosReservaConsulta datos){

        if(!pacienteRepository.existsById(datos.idPaciente())){
            throw  new ValidacionException("No existe un paciente con el id informado");
        }
        if(datos.idMedico() != null && !medicoRepository.existsById(datos.idMedico())){
            throw  new ValidacionException("No existe un medico con el id informado");
        }

        // validaciones
        validadores.forEach(v -> {
            v.validar(datos);
        });


        var medico = elegirMedico(datos);
        if(medico == null){
            throw  new ValidacionException("No existe un medico disponible con ese horario");
        }
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();

        var consulta = new Consulta(null, medico, paciente, datos.fecha(), null);

        consultaRepository.save(consulta);
        return new DatosDetalleConsulta(consulta);

    }

    private Medico elegirMedico(DatosReservaConsulta datos) {
        if(datos.idMedico() != null){
            return medicoRepository.getReferenceById(datos.idMedico());
        }
        if (datos.especialidad() == null){
            throw new ValidacionException("Es necesario elegir una especialidad cuando no se elige un medico");
        }

        return medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(datos.especialidad(), datos.fecha());

    }

    public void cancelar(DatosCancelamientoConsulta datos) {
        if(!consultaRepository.existsById(datos.idConsulta())){
            throw new ValidacionException("ID de la consulta informado no existe!");
        }
        validadoresCancelamiento.forEach(v -> v.validar(datos));
        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
        consulta.cancelar(datos.motivo());
    }
}
