package com.veimar.libreria_digital.services;

import com.veimar.libreria_digital.entities.Usuario;
import com.veimar.libreria_digital.repositories.UsuariosRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UsuariosServiceTest {

    // TAREA 3.3.1 Use Mockito to mock dependencies in the Loans microservice and verify
    // that interactions between services are performed correctly.
    @Mock
    private UsuariosRepository usuariosRepository;

    @InjectMocks
    private UsuariosService usuariosService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // TAREA 3.1.1 Implement unit tests for the UserServices.
    @Test
    void getAllUsuarios() {

        Usuario usuario = new Usuario(
            "Juan Perez",
            "juan.perez@example.com", "password123", true,
            LocalDateTime.now(),
            LocalDateTime.now()
        );

        usuariosService.insertUsuario(usuario);

        List<Usuario> usuarios = usuariosService.getAllUsuarios();
        Assertions.assertFalse(usuarios.isEmpty());
    }

}
