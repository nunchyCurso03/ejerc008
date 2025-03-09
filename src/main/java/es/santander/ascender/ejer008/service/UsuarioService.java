package es.santander.ascender.ejer008.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.ejer008.model.Usuario;
import es.santander.ascender.ejer008.repository.UsuarioRepository;

@Service
public class UsuarioService {

     @Autowired
    private UsuarioRepository usuarioRepository;

    // CRUD methods
      /**
     * Obtiene todos los usuarios
     */
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Obtiene un usuario por su ID
     */
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Guarda un nuevo usuario o actualiza uno existente
     */
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Elimina un usuario por su ID
     */
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    /**
     * Busca un usuario por su nombre de usuario
     */
    public Optional<Usuario> getUsuarioByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    /**
     * Verifica si un email ya está registrado
     */
    public boolean emailExists(String email) {
        return usuarioRepository.existsByPersona_Email(email);
    }
}


