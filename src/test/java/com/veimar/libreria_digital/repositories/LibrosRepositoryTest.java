package com.veimar.libreria_digital.repositories;

import com.veimar.libreria_digital.entities.Libro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LibrosRepositoryTest {

    @Autowired
    private LibrosRepository librosRepository;

    // TAREA 3.2 Perform tests on the Book repository to verify that CRUD operations work
    // correctly.
    @Test
    public void testGetAllLibros() {

        List<Libro> libros = librosRepository.findAll();
        Assertions.assertFalse(libros.isEmpty());

    }

    @Test
    public void testSaveLibro() {

        Libro libro = new Libro(
                "123456789",
                "El Marciano",
                "Ciencia ficción",
                "urlphoto",
                "libro",
                LocalDate.now(),
                102
        );

        Libro libroCreado = librosRepository.save(libro);
        Assertions.assertTrue(librosRepository.existsById(libroCreado.getId()));

    }

    @Test
    public void testFindByFormato() {

        Libro libro = new Libro(
                "123456789",
                "El Marciano",
                "Ciencia ficción",
                "urlphoto",
                "libro",
                LocalDate.now(),
                102
        );

        Libro libroCreado = librosRepository.save(libro);
        Assertions.assertTrue(librosRepository.existsById(libroCreado.getId()));

        List<Libro> libros = librosRepository.findByFormato("libro");
        Assertions.assertFalse(libros.isEmpty());

    }



}
