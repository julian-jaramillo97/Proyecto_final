package com.proyectofinal.proyecto_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.proyectofinal.proyecto_final.repository.*;
import com.proyectofinal.proyecto_final.domain.*;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Optional<Libro> findById(int id) {
        return libroRepository.findById(id);
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro updateLibro(int id, Libro libroDetails) {
        Optional<Libro> libro = libroRepository.findById(id);
        if (libro.isPresent()) {
            Libro updatedLibro = libro.get();
            updatedLibro.setTitulo(libroDetails.getTitulo());
            updatedLibro.setAutor(libroDetails.getAutor());
            updatedLibro.setGenero(libroDetails.getGenero());
            updatedLibro.setFecha_publicacion(libroDetails.getFecha_publicacion());
            updatedLibro.setIsbn(libroDetails.getIsbn());
            updatedLibro.setCantidad_disponible(libroDetails.getCantidad_disponible());
            updatedLibro.setDescripcion(libroDetails.getDescripcion());
            updatedLibro.setImagen_portada(libroDetails.getImagen_portada());
            return libroRepository.save(updatedLibro);
        } else {
            return null;
        }
    }

    public void deleteById(int id) {
        libroRepository.deleteById(id);
    }

    public List<Libro> buscarLibros(String titulo, String autor, String genero) {
        if (titulo != null) {
            return libroRepository.findByTituloContaining(titulo);
        } else if (autor != null) {
            return libroRepository.findByAutorContaining(autor);
        } else if (genero != null) {
            return libroRepository.findByGeneroContaining(genero);
        } else {
            return libroRepository.findAll();
        }
    }
}
