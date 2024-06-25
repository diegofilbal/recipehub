package org.example.recipehub.control;

import org.example.recipehub.model.Usuario;
import org.example.recipehub.model.dto.UsuarioDTO;
import org.example.recipehub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public String detalhar(Model model, @PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.detalhar(id);
        model.addAttribute("usuario", usuario);
        return "usuario/detalhar";
    }

    @GetMapping("/cadastrar")
    public String formUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioDTO());
        return "index";
    }

    @PostMapping()
    public String salvar(@ModelAttribute UsuarioDTO usuario) {
        UsuarioDTO novoUsuario = usuarioService.salvar(usuario);
        return "redirect:/usuarios/cadastrar";
    }

    @GetMapping("/{id}/deletar")
    public String deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return "redirect:/usuarios";
    }

}
