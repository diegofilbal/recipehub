package org.example.recipehub.control;

import org.example.recipehub.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conta")
public class ContaController {

    @GetMapping
    public String visualizar(Model model){
        model.addAttribute("usuario", new Usuario(1L, "André Luiz Cordeiro Silva Filho", "andrezinbr", "Mudar@123", "andrezinbr@gmail.com"));
        model.addAttribute("isEdicao", false);
        return "conta";
    }

    @GetMapping("/editar")
    public String editar(Model model){
        model.addAttribute("usuario", new Usuario(1L, "André Luiz Cordeiro Silva Filho", "andrezinbr", "Mudar@123", "andrezinbr@gmail.com"));
        model.addAttribute("isEdicao", true);
        return "conta";
    }

    @PostMapping
    public String atualizar(@ModelAttribute Usuario usuario) {
        return "redirect:/conta";
    }
}
