package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.persistencia.elastic;

import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.model.Personaje;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeDao extends ElasticsearchRepository<Personaje, String> {

    Personaje getPersonajeByNombre(String nombre);
}
