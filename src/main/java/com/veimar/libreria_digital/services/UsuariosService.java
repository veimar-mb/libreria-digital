package com.veimar.libreria_digital.services;

import com.veimar.libreria_digital.entities.Usuario;
import com.veimar.libreria_digital.repositories.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {

    private UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuario insertUsuario(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }

}
