package com.proyectofinal.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.proyecto_final.domain.*;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    List<Libro> findByTituloContaining(String titulo);
    List<Libro> findByAutorContaining(String autor);
    List<Libro> findByGeneroContaining(String genero);
}
