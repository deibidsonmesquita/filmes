package com.gdm.filmes.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nome;
    private String genero;
    private String img;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate lancamento;

    @ManyToOne
    private Diretor diretor;

    @Transient
    private long id_diretor;


}
