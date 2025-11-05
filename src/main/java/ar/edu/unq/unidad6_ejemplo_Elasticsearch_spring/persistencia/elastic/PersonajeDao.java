package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.persistencia.elastic;

import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.model.Personaje;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeDao extends ElasticsearchRepository<Personaje, String> {

    Personaje getPersonajeByNombre(String nombre);

    @Query("""
                {
                    "match": {
                      "descripcion": {
                        "query": "?0"
                      }
                    }
                  }
                
            """)
    List<Personaje> findPersonajesConDescripcion(String descripcion);
}
