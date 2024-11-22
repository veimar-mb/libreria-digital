package com.veimar.libreria_digital.controllers;

import com.veimar.libreria_digital.entities.Libro;
import com.veimar.libreria_digital.services.LibrosService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestion de Libros.
 */
@RestController
@RequestMapping("/api/libros")
public class LibrosController {

    private LibrosService librosService;

    public LibrosController(LibrosService librosService) {
        this.librosService = librosService;
    }

    /**
     * Obtiene todos los libros.
     *
     * @return una lista de todos los libros
     */
    @GetMapping
    public List<Libro> getAllLibros() {
        return librosService.getAllLibros();
    }

    /**
     * Obtiene un libro por el ID.
     *
     * @param id ID del libro
     * @return el libro correspondiente al ID, o 404 si no se encuentra
     */
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable  Long id) {
        Optional<Libro> libro = librosService.getLibroById(id);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Agrega un nuevo libro
     *
     * @param libro datos del libro a agregar
     * @return libro creado
     */
    @PostMapping
    public Libro addLibro(@RequestBody Libro libro) {
        return librosService.insertLibro(libro);
    }

    /**
     * Actualiza un libro por su ID.
     *
     * @param id Identificador del libro a actualizar
     * @param libro datos del libro actualizado
     * @return libro actualizado, 404 si no se encuentra
     */
    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libro) {

        Optional<Libro> libroOptional = librosService.getLibroById(id);

        if (libroOptional.isPresent()) {
            Libro libroToUpdate = libroOptional.get();
            libroToUpdate.setTitulo(libro.getTitulo());
            libroToUpdate.setDescripcion(libro.getDescripcion());
            libroToUpdate.setPortadaUrl(libro.getPortadaUrl());
            libroToUpdate.setFormato(libro.getFormato());
            libroToUpdate.setFechaPublicacion(libro.getFechaPublicacion());
            libroToUpdate.setNumeroPaginas(libro.getNumeroPaginas());
            librosService.insertLibro(libroToUpdate);
            return ResponseEntity.ok(libroToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Eliminar un libro por su ID.
     *
     * @param id Identificador del libro a eliminar
     * @return 204 si se elimina correctamente, 404 si no se encuentra
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {

        if (librosService.getLibroById(id).isPresent()) {
            librosService.deleteLibroById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Obtiene libros en paginacion y orden de campo indicado
     *
     * @param pagina Numero de pagina de resultados
     * @param tamanio Numero de elementos de pagina
     * @param campo Campo sobre el que se ordenaran los resultados
     * @return el libro correspondiente al ID, o 404 si no se encuentra
     */
    @GetMapping("/byPage")
    public Page<Libro> getLibrosByPage(@RequestParam int pagina, @RequestParam int tamanio, @RequestParam String campo) {
        return librosService.getLibrosByPage(pagina, tamanio, campo);
    }

}
