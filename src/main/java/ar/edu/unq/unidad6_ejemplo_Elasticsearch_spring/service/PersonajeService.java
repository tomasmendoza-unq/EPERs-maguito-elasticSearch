package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.service;

import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.model.Personaje;

public interface PersonajeService {

    Personaje findByNombre(String nombre);
    Personaje save(Personaje personaje);
}
