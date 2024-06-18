package com.proyectofinal.proyecto_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyectofinal.proyecto_final.services.*;
import com.proyectofinal.proyecto_final.domain.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    

    @Autowired
    private LibroService libroService;
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("libro", new Libro());
        return "libro_form";
    }
    
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroService.save(libro);
        return "redirect:/libros";
    }

    // Listar todos los libros
    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.findAll();
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public Optional<Libro> getLibroById(@PathVariable int id) {
        return libroService.findById(id);
    }

    // Buscar libros por título, autor o género
    @GetMapping("/buscar")
    public List<Libro> buscarLibros(@RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String genero) {
        return libroService.buscarLibros(titulo, autor, genero);
    }

    // Agregar un nuevo libro
    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    // Editar un libro existente
    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable int id, @RequestBody Libro libroDetails) {
        return libroService.updateLibro(id, libroDetails);
    }

    // Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable int id) {
        libroService.deleteById(id);
    }
}
