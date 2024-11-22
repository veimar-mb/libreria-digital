package com.veimar.libreria_digital.controllers;

import com.veimar.libreria_digital.entities.Usuario;
import com.veimar.libreria_digital.services.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestion de Usuarios.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    private UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return una lista de todos los usuarios
     */
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuariosService.getAllUsuarios();
    }

    /**
     * Obtiene un usuario por el ID.
     *
     * @param id ID del usuario
     * @return el usuario correspondiente al ID, o 404 si no se encuentra
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuariosService.getUsuarioById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Agrega un nuevo usuario
     *
     * @param usuario datos del usuario a agregar
     * @return usuario creado
     */
    @PostMapping
    public Usuario addUsuario(@Valid @RequestBody Usuario usuario) {
        return usuariosService.insertUsuario(usuario);
    }

    /**
     * Actualiza un usuario por su ID.
     *
     * @param id Identificador del usuario a actualizar
     * @param usuario datos del usuario actualizado
     * @return usuario actualizado, 404 sino se encuentra
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {

        Optional<Usuario> usuarioOptional = usuariosService.getUsuarioById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuarioToUpdate = usuarioOptional.get();

            usuarioToUpdate.setNombre(usuario.getNombre());
            usuarioToUpdate.setEmail(usuario.getEmail());
            usuarioToUpdate.setPassword(usuario.getPassword());
            usuarioToUpdate.setEnabled(usuario.isEnabled());
            usuariosService.insertUsuario(usuarioToUpdate);
            return ResponseEntity.ok(usuarioToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Eliminar un usuario por su ID.
     *
     * @param id Identificador del usuario a eliminar
     * @return 204 si se elimina correctamente, 404 sino se encuentra
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        if (usuariosService.getUsuarioById(id).isPresent()) {
            usuariosService.deleteUsuarioById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Busca un usuario por email.
     *
     * @param email el email del usuario
     * @return el usuario correspondiente al email, o 404 si no se encuentra
     */
    @GetMapping("/searchByEmail")
    public ResponseEntity<Usuario> searchByEmail(@RequestParam String email) {
        Optional<Usuario> usuario = usuariosService.searchUsuarioByEmail(email);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
