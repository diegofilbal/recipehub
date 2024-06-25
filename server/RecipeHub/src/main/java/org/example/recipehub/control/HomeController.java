package org.example.recipehub.control;

import org.example.recipehub.model.Usuario;
import org.example.recipehub.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuarioLogado = (Usuario) auth.getPrincipal();
        model.addAttribute("ultimasReceitas", receitaService.findUltimasReceitas(usuarioLogado.getId()));
        model.addAttribute("receitasFavoritas", receitaService.findReceitasFavoritas(usuarioLogado.getId()));
        model.addAttribute("receitasPadrao", receitaService.findReceitasByLogin("RecipeHub"));

        return "home";
    }
}
