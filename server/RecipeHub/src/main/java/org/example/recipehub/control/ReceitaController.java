package org.example.recipehub.control;

import org.example.recipehub.model.Receita;
import org.example.recipehub.model.dto.ReceitaDTO;
import org.example.recipehub.model.dto.UsuarioDTO;
import org.example.recipehub.service.ReceitaService;
import org.example.recipehub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receitas")

public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public UsuarioDTO detalhar(@PathVariable Long id) {
        return usuarioService.detalhar(id);
    }


    @PostMapping
    public ResponseEntity<Receita> salvar(@RequestBody ReceitaDTO receitaDTO) {
        try {
            Receita receita = receitaService.salvar(receitaDTO);
            return new ResponseEntity<>(receita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
