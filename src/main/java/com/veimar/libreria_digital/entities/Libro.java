package com.veimar.libreria_digital.entities;

import com.veimar.libreria_digital.utils.MinPages;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TAREA 1.1.2 Ensure that the ISBN field in Book is unique and not null.
    @Column(nullable = false, unique = true, length = 13)
    private String isbn;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(length = 1000)
    private String descripcion;

    @Column(name = "portada_url")
    private String portadaUrl;

    @Column(nullable = false)
    private String formato; // "físico" o "digital"

    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;

    // TAREA 1.2.1 Add a custom annotation @MinPages to the numeroPaginas field of the Libro entity.
    @Column(name = "numero_paginas")
    @MinPages(minimumPages = 100, message = "El libro debe tener al menos 100 páginas.")
    private Integer numeroPaginas;

    @ManyToMany(mappedBy = "libros")
    private Set<Usuario> usuarios;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String descripcion, String portadaUrl, String formato, LocalDate fechaPublicacion, Integer numeroPaginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.portadaUrl = portadaUrl;
        this.formato = formato;
        this.fechaPublicacion = fechaPublicacion;
        this.numeroPaginas = numeroPaginas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPortadaUrl() {
        return portadaUrl;
    }

    public void setPortadaUrl(String portadaUrl) {
        this.portadaUrl = portadaUrl;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
