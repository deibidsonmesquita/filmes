package com.gdm.filmes.repository;

import com.gdm.filmes.models.Diretor;
import com.gdm.filmes.models.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FilmesRepository extends JpaRepository<Filme, Long> {

    @Query("from Filme f where f.nome like %:filtro%")
    List<Filme> filtro(@Param("filtro") String filtro);

    List<Filme> findByNome(String nome);

    Diretor findById(long id);
}
