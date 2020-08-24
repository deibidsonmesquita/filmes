package com.gdm.filmes.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Diretor {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String nome;
    private int idade;

    @OneToMany(mappedBy = "diretor")
    private List<Filme> filmes;
}
