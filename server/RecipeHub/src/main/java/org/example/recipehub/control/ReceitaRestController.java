package org.example.recipehub.control;

import org.example.recipehub.model.Receita;
import org.example.recipehub.model.dto.ReceitaDTO;
import org.example.recipehub.service.ReceitaService;
import org.example.recipehub.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaRestController {

    @Autowired
    private ReceitaService receitaService;

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