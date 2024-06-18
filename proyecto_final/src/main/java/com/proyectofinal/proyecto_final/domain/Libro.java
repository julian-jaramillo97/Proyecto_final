package com.proyectofinal.proyecto_final.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "libros")
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String titulo;
    private String autor;
    private String genero;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_publicacion;
    
    private String isbn;
    
    @Column(nullable = false)
    private int cantidad_disponible;
    
    private String descripcion;
    private String imagen_portada;

    // Constructor vacío
    public Libro() {}

    // Constructor con parámetros
    public Libro(String titulo, String autor, String genero, Date fecha_publicacion, String isbn, int cantidad_disponible, String descripcion, String imagen_portada) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.fecha_publicacion = fecha_publicacion;
        this.isbn = isbn;
        this.cantidad_disponible = cantidad_disponible;
        this.descripcion = descripcion;
        this.imagen_portada = imagen_portada;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen_portada() {
        return imagen_portada;
    }

    public void setImagen_portada(String imagen_portada) {
        this.imagen_portada = imagen_portada;
    }
}
