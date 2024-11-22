package com.veimar.libreria_digital.repositories;

import com.veimar.libreria_digital.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// TAREA 4.1 Create a LibroRepository that allows CRUD operations on the Libro entity.
@Repository
public interface LibrosRepository extends JpaRepository<Libro, Long> {

    // TAREA 5.2 Create a native query in the LibroRepository to search for books by title
    //fragment using LIKE.
    @Query(value = "SELECT * FROM libros WHERE formato like ?1", nativeQuery = true)
    List<Libro> findByFormato(String formato);

}
