package es.santander.ascender.ejer008.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejer008.model.Usuario;
import es.santander.ascender.ejer008.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // MÉTODOS CRUD
    /**
     * Obtiene todos los usuarios
     */

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    /**
     * Obtener un usuario por ID
     */
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id).orElse(null);
    }

      /**
     * Crear un nuevo usuario
     */
    @PostMapping
    public  Usuario createUsuario(@RequestBody Usuario usuario) {
        if (usuario.getPersona() != null && usuarioService.emailExists(usuario.getPersona().getEmail())) {
            return null; // Si el email ya está registrado, devuelve null
        }
        return usuarioService.saveUsuario(usuario);
    }


       /**
     * Actualizar un usuario existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (!usuarioService.getUsuarioById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        Usuario updatedUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

        /**
     * Eliminar un usuario por ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        if (!usuarioService.getUsuarioById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

       /**
     * Buscar un usuario por nombre de usuario
     */
    @GetMapping("/buscar/{username}")
    public ResponseEntity<Usuario> getUsuarioByUsername(@PathVariable String username) {
        Optional<Usuario> usuario = usuarioService.getUsuarioByUsername(username);
        return usuario.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
