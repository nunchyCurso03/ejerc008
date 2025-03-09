package es.santander.ascender.ejer008.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import es.santander.ascender.ejer008.model.Provincia;
import es.santander.ascender.ejer008.repository.ProvinciaRepository;

@Service
@Transactional
public class ProvinciaService {
    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Transactional(readOnly = true)
    public List<Provincia> getAllProvincias() {
        return provinciaRepository.findAll();
    }

/*
    // Buscar provincias por ID
    public Optional<Provincia> getProvinciaById(Long id) {
        return provinciaRepository.findById(id);
    }

     // Buscar provincias por codigo
     public Optional<Provincia> getProvinciaByCodigo(String codigo) {
        return provinciaRepository.findByCodigo(codigo);
    }

    // CREATE
    public Provincia createProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    // READ ALL
    @Transactional(readOnly = true)
    public List<Provincia> getAllprovincias() {
        return provinciaRepository.findAll();
    }

    // READ ONE 
    @Transactional(readOnly = true)
    public Optional<Provincia> getprovinciaById(Long id) {
        return provinciaRepository.findById(id);
    }

    // UPDATE
    public Provincia updateProvincia(Long id, Provincia provinciaDetails) {
        Optional<Provincia> provinciaOptional = provinciaRepository.findById(id);
        if (provinciaOptional.isPresent()) {
            Provincia provincia = provinciaOptional.get();
            provincia.setNombre(provinciaDetails.getNombre());
            provincia.setCodigo(provinciaDetails.getCodigo());
            List<Persona> personas = provincia.getPersona();

            personas.clear();
            personas.addAll(provinciaDetails.getPersona());
            personas.stream().forEach(d -> d.setProvincia(provincia));

            return provinciaRepository.save(provincia);
        }
        return null;
    }*/
 
}