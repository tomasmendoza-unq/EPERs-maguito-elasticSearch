package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.service.impl;

import ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.service.ResetService;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ResetServiceImpl implements ResetService {

    private final ElasticsearchClient elasticsearchClient;

    public ResetServiceImpl(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @Override
    public void resetAll() {
        try {
            Set<String> indices = obtenerIndices();

            if (indices.isEmpty()) {
                log.warn("No se encontraron índices de Elasticsearch para borrar.");
                return;
            }

            for (String index : indices) {
                borrarIndice(index);
            }

        } catch (Exception e) {
            log.error("Error al resetear Elasticsearch", e);
        }
    }

    /**
     * Devuelve todos los índices excepto los de sistema.
     */
    private Set<String> obtenerIndices() throws IOException {

        GetIndexResponse response = elasticsearchClient.indices()
                .get(b -> b.index("*"));

        return response.result().keySet().stream()
                .filter(i -> !i.startsWith(".")) // ignorar índices de sistema
                .collect(Collectors.toSet());
    }

    private void borrarIndice(String index) {
        try {
            elasticsearchClient.indices().delete(d -> d.index(index));
            log.info("Índice eliminado: {}", index);
        } catch (Exception e) {
            log.error("Error eliminando índice {}", index, e);
        }
    }
}