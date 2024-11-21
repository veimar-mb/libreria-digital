package com.veimar.libreria_digital.controllers;

import com.veimar.libreria_digital.entities.Libro;
import com.veimar.libreria_digital.services.LibrosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {

    private LibrosService librosService;

    public LibrosController(LibrosService librosService) {
        this.librosService = librosService;
    }

    @GetMapping
    public List<Libro> getAllLibros() {
        return librosService.getAllLibros();
    }

    @PostMapping
    public Libro addLibro(@RequestBody Libro libro) {
        return librosService.insertLibro(libro);
    }

}
