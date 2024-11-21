package com.veimar.libreria_digital.controllers;

import com.veimar.libreria_digital.entities.Usuario;
import com.veimar.libreria_digital.services.UsuariosService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    private UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuariosService.getAllUsuarios();
    }

    @PostMapping
    public Usuario addUsuario(@RequestBody Usuario usuario) {

        return usuariosService.insertUsuario(usuario);

    }

}
