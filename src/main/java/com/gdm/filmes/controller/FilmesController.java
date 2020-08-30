package com.gdm.filmes.controller;

import com.gdm.filmes.models.Filme;
import com.gdm.filmes.repository.DiretorRepository;
import com.gdm.filmes.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/filmes/")
public class FilmesController {

    @Autowired
    private FilmesRepository filmesRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("filmes", filmesRepository.findAll());

        return "/filmes/home";
    }

    @GetMapping("novo")
    public String cadastro(Filme filme, Model model) {
        model.addAttribute("diretores", diretorRepository.findAll());
        return "/filmes/form";
    }

    @PostMapping("salvar")
    public String salvar(Filme filme, Model model) {
        // filme.setDiretor(diretorRepository.findById(id_diretor));
        filmesRepository.save(filme);
        model.addAttribute("filmes", filmesRepository.findAll());
        return "/filmes/home";
    }

    @GetMapping("busca")
    public String resultado(@RequestParam("filtro") String filtro, Model model) {
        model.addAttribute("filmes", filmesRepository.filtro(filtro).size() == 0 ? null : filmesRepository.filtro(filtro));
        return "/filmes/home";
    }


}
