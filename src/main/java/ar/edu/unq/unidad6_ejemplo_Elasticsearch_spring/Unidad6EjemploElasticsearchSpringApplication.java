package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class Unidad6EjemploElasticsearchSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Unidad6EjemploElasticsearchSpringApplication.class, args);
	}

}
