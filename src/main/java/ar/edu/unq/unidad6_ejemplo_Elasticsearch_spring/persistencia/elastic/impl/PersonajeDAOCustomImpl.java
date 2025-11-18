package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.persistencia.elastic.impl;

import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.model.Personaje;
import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.persistencia.elastic.PersonajeDAOCustom;
import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.persistencia.elastic.PersonajeDao;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.springframework.stereotype.Repository;

import java.io.IOException;


@Repository
public class PersonajeDAOCustomImpl implements PersonajeDAOCustom {
    private final ElasticsearchClient client;

    public PersonajeDAOCustomImpl(ElasticsearchClient client) {
        this.client = client;
    }

    @Override
    public Double obtenerPromedioVida() throws IOException {
        var  response = client.search(s -> s
                        .index("personaje")
                        .size(0)
                        .aggregations("promedio" , a -> a.avg(avg -> avg.field("vida"))
                        ), Personaje.class
                );
        return response.aggregations().get("promedio").avg().value();
    }
}
