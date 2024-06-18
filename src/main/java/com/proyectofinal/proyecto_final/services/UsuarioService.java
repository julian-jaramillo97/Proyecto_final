package com.proyectofinal.proyecto_final.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.proyectofinal.proyecto_final.repository.*;
import com.proyectofinal.proyecto_final.domain.*;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LibroService libroService;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(int id, Usuario usuarioDetails) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            Usuario updatedUsuario = usuario.get();
            updatedUsuario.setNombre(usuarioDetails.getNombre());
            updatedUsuario.setApellido(usuarioDetails.getApellido());
            updatedUsuario.setEmail(usuarioDetails.getEmail());
            updatedUsuario.setContraseña(usuarioDetails.getContraseña());
            updatedUsuario.setRol(usuarioDetails.getRol());
            updatedUsuario.setFecha_registro(usuarioDetails.getFecha_registro());
            return usuarioRepository.save(updatedUsuario);
        } else {
            return null;
        }
    }

    public void deleteById(int id) {
        usuarioRepository.deleteById(id);
    }

    public List<Libro> listarLibrosParaPrestamo() {
        return libroService.findAll();
    }
}