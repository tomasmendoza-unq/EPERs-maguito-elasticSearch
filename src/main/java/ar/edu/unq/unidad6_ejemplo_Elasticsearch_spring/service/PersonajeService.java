package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.service;

import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.model.Personaje;

import java.util.List;

public interface PersonajeService {

    Personaje findByNombre(String nombre);
    Personaje save(Personaje personaje);

    List<Personaje> findPersonajesConDescripcion(String muyPoderoso);

    public List<Personaje> buscarEnNombreODescripcion(String query);
}
