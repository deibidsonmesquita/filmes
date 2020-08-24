package com.gdm.filmes.controller;


import com.gdm.filmes.models.Diretor;
import com.gdm.filmes.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorRepository diretorRepository;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("diretores", diretorRepository.findAll() != null ? diretorRepository.findAll() : null);
        return "/diretores/home";
    }

    @GetMapping("/cadastro")
    public String add(Diretor diretor) {
        return "/diretores/form";
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(Diretor diretor) {
        diretorRepository.save(diretor);
        ModelAndView model = new ModelAndView("/diretores/home");
        model.addObject("diretores", diretorRepository.findAll());
        return model;
    }
}
