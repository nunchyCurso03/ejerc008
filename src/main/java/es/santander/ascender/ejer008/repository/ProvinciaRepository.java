package es.santander.ascender.ejer008.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejer008.model.Provincia;

public interface ProvinciaRepository  extends JpaRepository<Provincia, Long> {
    Optional<Provincia> findByCodigo(String codigo);

}
