package es.santander.ascender.ejer008.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejer008.model.Provincia;
import es.santander.ascender.ejer008.service.ProvinciaService;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

     // Create

    @PostMapping
    public ResponseEntity<Provincia> createProvincia(@RequestBody Provincia provincia) {
        provincia.getPersona().forEach(d -> d.setProvincia(provincia)); 
        Provincia createdProvincia = provinciaService.createProvincia(provincia);

        return new ResponseEntity<>(provinciaService.createProvincia(provincia), HttpStatus.CREATED);
    }
    // Read (all)
    @GetMapping
    public ResponseEntity<List<Provincia>> getAllprovincias() {
        List<Provincia> provincias = provinciaService.getAllprovincias();
        return new ResponseEntity<>(provinciaService.getAllprovincias(), HttpStatus.OK);
    }
       // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Provincia> getProvinciaById(@PathVariable Long id) {
        Optional<Provincia> provincia = provinciaService.getProvinciaById(id);  
        if (provincia.isPresent()) {
            return new ResponseEntity<>(provincia.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 

    // Update
    @PostMapping("/{id}")
    public ResponseEntity<Provincia> updateProvincia(@PathVariable Long id, @RequestBody Provincia provinciaDetails) {
        Provincia updatedProvincia = provinciaService.updateProvincia(id, provinciaDetails);
        if (updatedProvincia != null) {
            return new ResponseEntity<>(updatedProvincia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
}
