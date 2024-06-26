package org.example.recipehub.control;

import jakarta.validation.Valid;
import org.example.recipehub.model.Categoria;
import org.example.recipehub.model.Receita;
import org.example.recipehub.model.Usuario;
import org.example.recipehub.model.dto.PesquisaDTO;
import org.example.recipehub.model.dto.ReceitaDTO;
import org.example.recipehub.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public String findAll(@RequestParam(required = false) String categoria,
                          @RequestParam(required = false) String nome,
                          Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuarioLogado = (Usuario) auth.getPrincipal();

        model.addAttribute("pesquisa", new PesquisaDTO(categoria, nome));
        model.addAttribute("receitas", receitaService.findAll(usuarioLogado.getId(), categoria, nome));
        return "receitas";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("pesquisa", new PesquisaDTO());
        model.addAttribute("receita", receitaService.findById(id));
        return "receita";
    }

    @GetMapping("/nova")
    public String form(Model model){
        model.addAttribute("receitaDTO", new ReceitaDTO());
        return "nova-receita";
    }



    @PostMapping("/salvar")
    public String salvar(@ModelAttribute @Valid ReceitaDTO receitaDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "nova-receita";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuarioLogado = (Usuario) auth.getPrincipal();
        receitaDTO.setUsuarioId(usuarioLogado.getId());
        Receita receita = receitaService.salvar(receitaDTO);
        return "redirect:/receitas/" + receita.getId();
    }

    @PostMapping("/{id}/favoritar")
    public String favoritar(@PathVariable Long id) {
        receitaService.favoritar(id);
        return "redirect:/receitas/" + id;
    }

    @PostMapping("/{id}/excluir")
    public String excluirReceita(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Receita receita = receitaService.findById(id);

        if(receita == null) {
            redirectAttributes.addFlashAttribute("error", "Receita não encontrada!");
            return "redirect:/receitas";
        }
        receitaService.excluir(id);
        redirectAttributes.addFlashAttribute("sucess", "Receita excluída com sucesso.");
        return "redirect:/receitas";
    }


}
