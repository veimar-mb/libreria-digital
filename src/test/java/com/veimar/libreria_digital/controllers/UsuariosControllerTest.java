package com.veimar.libreria_digital.controllers;

import com.veimar.libreria_digital.entities.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuariosControllerTest {

    @Autowired
    UsuariosController usuariosController;

    // TAREA 3.1.2 Create integration tests that verify the full registration of a
    //user.
    @Test
    public void testCreateReadDelete() {

        // Agregar usuario nuevo
        Usuario usuario = new Usuario(
            "Juan Perez",
            "juan.perez@example.com", "password123", true,
            LocalDateTime.now(),
            LocalDateTime.now()
        );

        Long idUsuario = usuariosController.addUsuario(usuario).getId();

        // Verificacion de usuarios
        List<Usuario> usuarios = usuariosController.getAllUsuarios();
        Assertions.assertFalse(usuarios.isEmpty());

        // Verificar inserción correcta
        Usuario usuarioCreado = usuariosController.getUsuarioById(idUsuario).getBody();
        Assertions.assertNotNull(usuarioCreado);

        // Verificacion de eliminacion correcta
        usuariosController.deleteUsuario(usuario.getId());
        Usuario usuarioEliminado = usuariosController.getUsuarioById(idUsuario).getBody();
        Assertions.assertNull(usuarioEliminado);


    }

}
