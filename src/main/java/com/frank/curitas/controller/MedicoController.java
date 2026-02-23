package com.frank.curitas.controller;

import com.frank.curitas.medico.DatosRegistroMedico;
import com.frank.curitas.medico.Medico;
import com.frank.curitas.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody DatosRegistroMedico datos){
        repository.save(new Medico(datos));
    }
}
