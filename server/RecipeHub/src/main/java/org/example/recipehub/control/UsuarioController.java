package org.example.recipehub.control;

import org.example.recipehub.model.Usuario;
import org.example.recipehub.model.dto.UsuarioDTO;
import org.example.recipehub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public String detalhar(Model model, @PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.detalhar(id);
        model.addAttribute("usuario", usuario);
        return "usuario/detalhar";
    }

    @PostMapping
    public String salvar(@ModelAttribute("usuario") UsuarioDTO usuario, RedirectAttributes attributes) {
        try {
            UsuarioDTO novoUsuario = usuarioService.salvar(usuario);
            return "redirect:/login";
        } catch (Exception e) {
            attributes.addFlashAttribute("registerError", e.getMessage());
            return "redirect:/usuarios/form?register=true";
        }
    }

    @GetMapping("/form")
    public String index(@RequestParam(name = "register", required = false) String register, Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        if (register != null && register.equals("true")) {
            model.addAttribute("register", true);
        }
        return "index"; // Certifique-se de que "index" é a página correta do formulário de registro
    }

    @GetMapping("/{id}/deletar")
    public String deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return "redirect:/usuarios";
    }
}
