package org.example.recipehub.control;

import org.example.recipehub.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public String home(Model model){
        model.addAttribute("ultimasReceitas", receitaService.findUltimasReceitas());
        model.addAttribute("receitasFavoritas", receitaService.findReceitasFavoritas());
        return "home";
    }
}
