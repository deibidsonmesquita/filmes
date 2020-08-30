package com.gdm.filmes.controller;

import com.gdm.filmes.repository.UtilHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UtilHomeRepository utilHomeRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tops", utilHomeRepository.top3());
        return "index";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }
}
