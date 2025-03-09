package es.santander.ascender.ejer008;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.santander.ascender.ejer008.model.Provincia;
import es.santander.ascender.ejer008.repository.ProvinciaRepository;

@SpringBootApplication
public class Ejer008Application {
	@Autowired
    private ProvinciaRepository provinciaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ejer008Application.class, args);
	}

	@Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            // Check if there are already provinces in the database
            if (provinciaRepository.count() == 0) {
                // Create some provinces
                List<Provincia> provincias = Arrays.asList(
                        new Provincia(null, "Madrid", "28", "Comunidad de Madrid"),
                        new Provincia(null, "Barcelona", "08", "Cataluña"),
                        new Provincia(null, "Valencia", "46", "Comunidad Valenciana"),
                        new Provincia(null, "Sevilla", "41", "Andalucía"),
                        new Provincia(null, "Zaragoza", "50", "Aragón"),
                        new Provincia(null, "Málaga", "29", "Andalucía"),
                        new Provincia(null, "Murcia", "30", "Región de Murcia")

                );

                // Save the provinces to the database
                provinciaRepository.saveAll(provincias);

                System.out.println("Provincias cargadas en la base de datos.");
            } else {
                System.out.println("Ya existen provincias en la base de datos. No se han cargado.");
            }
        };
    }

}
