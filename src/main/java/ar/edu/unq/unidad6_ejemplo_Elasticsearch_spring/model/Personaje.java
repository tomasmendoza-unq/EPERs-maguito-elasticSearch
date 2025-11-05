package ar.edu.unq.unidad6_ejemplo_Elasticsearch_spring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "persona")
public class Personaje {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String nombre;

    @Field(type = FieldType.Text)
    private String descripcion;

    private int vida;

    @Field(type = FieldType.Integer)
    private int pesoMaximo;

    private Set<Item> inventario = new HashSet<>();

    public Personaje(String nombre, String descripcion, int pesoMaximo, int vida) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pesoMaximo = pesoMaximo;
        this.vida = vida;
    }
}
