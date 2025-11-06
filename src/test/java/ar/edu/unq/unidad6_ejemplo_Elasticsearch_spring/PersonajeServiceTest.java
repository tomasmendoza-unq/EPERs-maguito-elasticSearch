package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring;

import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.model.Personaje;
import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.service.PersonajeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PersonajeServiceTest {


    @Autowired
    private PersonajeService personajeService;


    //@BeforeEach
    public void setUp() {
        personajeService.save(new Personaje( "caballero", "un caballero muy poderoso",21, 12));
        personajeService.save(new Personaje( "paladin", "un paladin muy poderoso",21, 12));
        personajeService.save(new Personaje( "arquero", "un arquero muy poderoso",21, 12));
        personajeService.save(new Personaje( "Druida", "un druida muy poderoso",21, 12));

    }

    @Test
    public void save() {
        Personaje personaje = new Personaje( "Maguito", "un mago muy poderoso",21, 12);

        Personaje saved = personajeService.save(personaje);

        assertEquals(personaje.getNombre(), saved.getNombre());
    }


    @Test
    public void findPersonajesPorDescripcionDeMasPoderoso(){
        List<Personaje> personajes = personajeService.findPersonajesConDescripcion("muy poderoso");

        assertEquals(6, personajes.size());
        assertTrue(personajes.stream().map(Personaje::getDescripcion).allMatch(d -> d.contains("muy poderoso")));
    }


}
