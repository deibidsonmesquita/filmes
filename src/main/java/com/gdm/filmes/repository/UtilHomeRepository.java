package com.gdm.filmes.repository;

import com.gdm.filmes.models.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UtilHomeRepository extends JpaRepository<Filme, Long> {
    @Query(nativeQuery = true, value = "select * from filme limit 3")
    List<Filme> top3();
}
