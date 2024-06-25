package org.example.recipehub.control;

import org.example.recipehub.model.dto.UsuarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        model.addAttribute("register", false);

        return "index";
    }

    @GetMapping("/cadastrar")
    public String formUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        model.addAttribute("register", true);

        return "index";
    }
}
