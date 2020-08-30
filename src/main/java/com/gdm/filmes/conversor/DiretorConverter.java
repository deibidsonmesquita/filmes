package com.gdm.filmes.conversor;

import com.gdm.filmes.models.Diretor;
import com.gdm.filmes.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DiretorConverter implements Converter<String, Diretor> {

    @Autowired
    private DiretorRepository diretorRepository;

    @Override
    public Diretor convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        return diretorRepository.findById(Long.parseLong(source));
    }
}
