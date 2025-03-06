package es.santander.ascender.ejer008.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejer008.model.Persona;
import es.santander.ascender.ejer008.model.Provincia;
import es.santander.ascender.ejer008.service.PersonaService;
import es.santander.ascender.ejer008.service.ProvinciaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ProvinciaService provinciaService;

   // Create
    @PostMapping
    public ResponseEntity<?> createPersona(@RequestBody Persona persona) {
        if (persona.getProvincia() == null || persona.getProvincia().getCodigo() == null){
            return new ResponseEntity<>("Obligatorio Codigo de provincia", HttpStatus.BAD_REQUEST);
        }
        Optional<Provincia> provincia = provinciaService.getProvinciaById(persona.getProvincia().getId());

        if (!provincia.isPresent()){
            return new ResponseEntity<>("la provincia con id: "+ persona.getProvincia().getId() + " no existe", HttpStatus.BAD_REQUEST);
        }
        persona.setProvincia(provincia.get());
        Persona createdPersona = personaService.createPersona(persona);
        return new ResponseEntity<>(createdPersona, HttpStatus.CREATED);
    }
    // Read (all)
    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = personaService.getAllPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Optional<Persona> persona = personaService.getPersonaById(id);
        if (persona.isPresent()) {
            return new ResponseEntity<>(persona.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PostMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona updatedPersona) {
        Persona persona = personaService.updatePersona(id, updatedPersona);
        if (persona != null) {
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

      // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePersona(@PathVariable Long id) {
        boolean deleted = personaService.deletePersona(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
