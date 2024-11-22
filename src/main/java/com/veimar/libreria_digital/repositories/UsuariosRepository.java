package com.veimar.libreria_digital.repositories;

import com.veimar.libreria_digital.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

    // TAREA 4.2 In the UserRepository, create a derived query to find users by their email address.
    Optional<Usuario> findByEmail(String email);

}
