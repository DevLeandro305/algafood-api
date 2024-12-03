package com.lfsoares.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("gastronomia")
@Entity
@Table(name = "tb_cozinha")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

//  @JsonIgnore     -> Serve para ignorar um campo na hora de montar a representação na requisição
    @JsonProperty("titulo")
    @Column(nullable = false)
    private String nome;
}
