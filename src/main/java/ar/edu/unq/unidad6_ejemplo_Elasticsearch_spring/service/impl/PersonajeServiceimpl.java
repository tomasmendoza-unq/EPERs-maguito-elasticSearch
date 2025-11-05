package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.service.impl;

import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.model.Personaje;
import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.persistencia.elastic.PersonajeDao;
import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.service.PersonajeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return personajeDao.save(personaje);
    }

    @Override
    public List<Personaje> findPersonajesConDescripcion(String muyPoderoso) {
        return personajeDao.findPersonajesConDescripcion(muyPoderoso);
    }
}
