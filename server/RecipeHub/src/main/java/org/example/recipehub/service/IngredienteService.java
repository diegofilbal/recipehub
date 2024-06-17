package org.example.recipehub.service;

import org.example.recipehub.model.Ingrediente;
import org.example.recipehub.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Transactional
    public Ingrediente encontrarOuCriarPornome(String nome) {
        return ingredienteRepository.findByNome(nome)
                .orElseGet(() -> ingredienteRepository.save(new Ingrediente(nome)));
    }
}
