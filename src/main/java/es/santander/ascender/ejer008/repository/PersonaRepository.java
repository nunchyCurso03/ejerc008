package es.santander.ascender.ejer008.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejer008.model.Persona;

public interface PersonaRepository  extends JpaRepository<Persona, Long> {

}
