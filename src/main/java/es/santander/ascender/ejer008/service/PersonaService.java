package es.santander.ascender.ejer008.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.ejer008.repository.PersonaRepository;

@Service
public class PersonaService {
     @Autowired
    private PersonaRepository personaRepository;

}
