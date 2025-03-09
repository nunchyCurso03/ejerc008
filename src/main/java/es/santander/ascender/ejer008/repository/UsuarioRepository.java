package es.santander.ascender.ejer008.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.santander.ascender.ejer008.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    
     // Buscar usuario por nombre de usuario (username)
     Optional<Usuario> findByUsername(String username);

     // Verificar si un usuario existe por email
   //¿¿ERROR??  boolean existsByEmail(String email);

     // Método para verificar si el email de la Persona asociada existe
     boolean existsByPersona_Email(String email);

}
