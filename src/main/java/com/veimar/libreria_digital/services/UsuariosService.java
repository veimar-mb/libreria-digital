package com.veimar.libreria_digital.services;

import com.veimar.libreria_digital.entities.Usuario;
import com.veimar.libreria_digital.repositories.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que contiene las operaciones para la gestion de los usuarios
 */
@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuario> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuariosRepository.findById(id);
    }

    public Usuario insertUsuario(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }

    public void deleteUsuarioById(Long id) {
        usuariosRepository.deleteById(id);
    }

    public Optional<Usuario> searchUsuarioByEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }

    // TAREA 6.1 Ensure that book loans are atomic by using @Transactional in the Loans microservice.
    @Transactional
    public Optional<Usuario> updateUsuario(Long id, Usuario usuario) {

        Optional<Usuario> usuarioBd = getUsuarioById(id);

        if (usuarioBd.isPresent()) {
            Usuario usuarioToUpdate = usuarioBd.get();

            usuarioToUpdate.setNombre(usuario.getNombre());
            usuarioToUpdate.setEmail(usuario.getEmail());
            usuarioToUpdate.setPassword(usuario.getPassword());
            usuarioToUpdate.setEnabled(usuario.isEnabled());
            insertUsuario(usuarioToUpdate);

            return Optional.of(usuarioToUpdate);
        }

        return Optional.empty();
    }

}
