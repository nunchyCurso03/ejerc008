package es.santander.ascender.ejer008.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.ejer008.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

     @Autowired
    private ProvinciaRepository provinciaRepository;


}
