package com.frank.curitas.controller;

import com.frank.curitas.domain.usuario.DatosAutenticacion;
import com.frank.curitas.domain.usuario.Usuario;
import com.frank.curitas.infra.security.DatosTokenJWT;
import com.frank.curitas.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService;


    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutenticacion datos){
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var autentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((Usuario) autentication.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));

    }
}
