package com.gdm.filmes.repository;

import com.gdm.filmes.models.Diretor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiretorRepository extends CrudRepository<Diretor, Long> {

    List<Diretor> findByNome(String nome);

    Diretor findById(long id);
}
