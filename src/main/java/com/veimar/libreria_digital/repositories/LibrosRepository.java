package com.veimar.libreria_digital.repositories;

import com.veimar.libreria_digital.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TAREA 4.1 Create a LibroRepository that allows CRUD operations on the Libro entity.
@Repository
public interface LibrosRepository extends JpaRepository<Libro, Long> {

}
