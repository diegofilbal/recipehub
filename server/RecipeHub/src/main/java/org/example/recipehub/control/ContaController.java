package org.example.recipehub.control;

import org.example.recipehub.model.Usuario;
import org.example.recipehub.model.dto.UsuarioDTO;
import org.example.recipehub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String visualizar(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuarioLogado = (Usuario) auth.getPrincipal();

        UsuarioDTO usuario = usuarioService.detalhar(usuarioLogado.getId());

        model.addAttribute("usuario", usuario);
        model.addAttribute("isEdicao", false);
        return "conta";
    }

    @GetMapping("/editar")
    public String editar(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuarioLogado = (Usuario) auth.getPrincipal();

        UsuarioDTO usuario = usuarioService.detalhar(usuarioLogado.getId());

        model.addAttribute("usuario", usuario);
        model.addAttribute("isEdicao", true);
        return "conta";
    }

    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute("usuario") UsuarioDTO usuarioDto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.usuario", result);
            redirectAttributes.addFlashAttribute("usuario", usuarioDto);
            return "redirect:/conta/editar";
        }

        try {
            Usuario usuarioAtualizado = usuarioService.atualizar(usuarioDto);
            redirectAttributes.addFlashAttribute("success", "Dados atualizados com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/conta";
    }

}
