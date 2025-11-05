package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring;

import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.model.Personaje;
import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.service.PersonajeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonajeServiceTest {


    @Autowired
    private PersonajeService personajeService;


    @Test
    public void save() {
        Personaje personaje = new Personaje("12", "Robert", 21, 12, new HashSet<>());

        Personaje saved = personajeService.save(personaje);

        assertEquals(personaje.getNombre(), saved.getNombre());
    }
}
