package com.frank.curitas.controller;

import com.frank.curitas.medico.DatosListaMedico;
import com.frank.curitas.medico.DatosRegistroMedico;
import com.frank.curitas.medico.Medico;
import com.frank.curitas.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos){
        repository.save(new Medico(datos));
    }

    @GetMapping
    public Page<DatosListaMedico> listar(Pageable paginacion){
        return repository.findAll(paginacion).map(DatosListaMedico::new);
    }
}
