package com.veimar.libreria_digital.services;

import com.veimar.libreria_digital.entities.Libro;
import com.veimar.libreria_digital.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Libro> findByFormato(String formato, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        return repository.findByFormato(formato);
    }

    // TAREA 4.3 Add pagination and sorting support in the Book Catalog microservice to list books by popularity order.
    public Page<Libro> getLibrosByPage(int pagina, int tamanio, String campo) {
        Sort orderBy = Sort.by(campo);
        Pageable pageable = PageRequest.of(pagina, tamanio, orderBy);

        return repository.findAll(pageable);
    }
}
