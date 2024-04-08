package org.example.recipehub.control;

import org.example.recipehub.model.Usuario;
import org.example.recipehub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public String listar(Model model) {
        List<Usuario> usuarios = usuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "usuario/listar";
    }

    @GetMapping("/{id}")
    public String detalhar(Model model, @PathVariable Long id) {
        Usuario usuario = usuarioService.detalhar(id);
        model.addAttribute("usuario", usuario);
        return "usuario/detalhar";
    }

    @GetMapping("/cadastrar")
    public String formUsuario() {
        return "usuario/cadastrar";
    }

    @PostMapping()
    public String salvar(Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/{id}/deletar")
    public String deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return "redirect:/usuarios";
    }

}
