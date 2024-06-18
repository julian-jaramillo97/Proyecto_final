package com.proyectofinal.proyecto_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.proyectofinal.proyecto_final.domain.*;
import com.proyectofinal.proyecto_final.services.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario_form";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    // Listar todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable int id) {
        return usuarioService.findById(id);
    }

    // Registrar un nuevo usuario
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    // Editar la información de un usuario existente
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable int id, @RequestBody Usuario usuarioDetails) {
        return usuarioService.updateUsuario(id, usuarioDetails);
    }

    // Añadir préstamo de libro (redirige a la lista de libros)
    @GetMapping("/{id}/prestamos")
    public List<Libro> listarLibrosParaPrestamo(@PathVariable int id) {
        return usuarioService.listarLibrosParaPrestamo();
    }
}
