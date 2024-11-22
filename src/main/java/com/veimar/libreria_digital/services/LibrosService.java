package com.veimar.libreria_digital.services;

import com.veimar.libreria_digital.entities.Libro;
import com.veimar.libreria_digital.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que contiene las operaciones para la gestion de los Libros
 */
@Service
public class LibrosService {

    // TAREA 2.1.1 Use @Autowired to inject the repositories into the UserService and BookService.
    @Autowired
    private LibrosRepository repository;

    public List<Libro> getAllLibros() {
        return repository.findAll();
    }

    public Optional<Libro> getLibroById(long id) {
        return repository.findById(id);
    }

    public Libro insertLibro(Libro libro) {
        return repository.save(libro);
    }

    public void deleteLibroById(long id) {
        repository.deleteById(id);
    }
}
