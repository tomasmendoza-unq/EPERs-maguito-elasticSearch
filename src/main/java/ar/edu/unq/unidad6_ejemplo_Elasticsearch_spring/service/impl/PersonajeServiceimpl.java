package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.service.impl;

import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.model.Personaje;
import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.persistencia.elastic.PersonajeDao;
import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.service.PersonajeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@Transactional
public class PersonajeServiceimpl implements PersonajeService {

    private final PersonajeDao personajeDao;

    public PersonajeServiceimpl(PersonajeDao personajeDao) {
        this.personajeDao = personajeDao;
    }


    @Override
    public Personaje findByNombre(String nombre) {
        return personajeDao.getPersonajeByNombre(nombre);
    }

    @Override
    public Personaje save(Personaje personaje) {
        Personaje saved = personajeDao.save(personaje);

        log.info("CREADO Personaje id={} nombre={} vida={} pesoMax={}",
                saved.getId(),
                saved.getNombre(),
                saved.getVida(),
                saved.getPesoMaximo());


        return saved;
    }

    @Override
    public List<Personaje> findPersonajesConDescripcion(String muyPoderoso) {
        return personajeDao.findPersonajesConDescripcion(muyPoderoso);
    }


    public List<Personaje> buscarEnNombreODescripcion(String query){
        List <Personaje> response = personajeDao.findPersonajesConDescripcionONombre(query);
        return response;
    }


    public Double obtenerPromedioVida() {
        try {
            return personajeDao.obtenerPromedioVida();
        } catch (IOException e) {
            throw new IllegalStateException("Fallo al comunicarse con Elasticsearch", e);
        }

    }

}
