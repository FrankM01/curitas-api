package com.frank.curitas.controller;

import com.frank.curitas.domain.consulta.DatosDetalleConsulta;
import com.frank.curitas.domain.consulta.DatosReservaConsulta;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity reservar(@RequestBody @Valid DatosReservaConsulta datos){
        return ResponseEntity.ok(new DatosDetalleConsulta(null, null, null, null));
    }
}
