package com.veimar.libreria_digital.services;

import com.veimar.libreria_digital.entities.Libro;
import com.veimar.libreria_digital.repositories.LibrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrosService {

    private LibrosRepository repository;

    public LibrosService(LibrosRepository repository) {
        this.repository = repository;
    }

    public List<Libro> getAllLibros() {
        return repository.findAll();
    }

    public Libro insertLibro(Libro libro) {
        return repository.save(libro);
    }
}
