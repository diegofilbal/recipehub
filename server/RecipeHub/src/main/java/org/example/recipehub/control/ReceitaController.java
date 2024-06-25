package org.example.recipehub.control;

import org.example.recipehub.model.Categoria;
import org.example.recipehub.model.Receita;
import org.example.recipehub.model.dto.PesquisaDTO;
import org.example.recipehub.model.dto.ReceitaDTO;
import org.example.recipehub.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public String findAll(@RequestParam(required = false) String categoria,
                          @RequestParam(required = false) String nome,
                          Model model){
        Long usuarioId = 2L;
        model.addAttribute("pesquisa", new PesquisaDTO(categoria, nome));
        model.addAttribute("receitas", receitaService.findAll(usuarioId, categoria, nome));
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
        model.addAttribute("receita", new ReceitaDTO());
        return "nova-receita";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute ReceitaDTO receitaDTO) {
        receitaDTO.setUsuarioId(2L);
        Receita receita = receitaService.salvar(receitaDTO);
        return "redirect:/receitas/" + receita.getId();
    }

    @PostMapping("/{id}/favoritar")
    public String favoritar(@PathVariable Long id) {
        receitaService.favoritar(id);
        return "redirect:/receitas/" + id;
    }
}
