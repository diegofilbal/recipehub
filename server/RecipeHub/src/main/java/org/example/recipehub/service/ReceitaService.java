package org.example.recipehub.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.recipehub.model.Ingrediente;
import org.example.recipehub.model.Receita;
import org.example.recipehub.model.IngredienteReceita;
import org.example.recipehub.model.Usuario;
import org.example.recipehub.model.dto.PesquisaDTO;
import org.example.recipehub.model.dto.ReceitaDTO;
import org.example.recipehub.repository.ReceitaRepository;
import org.example.recipehub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IngredienteService ingredienteService;

    public List<Receita> findAll() {
        return receitaRepository.findAll();
    }

    public Receita findById(Long id) {
        return receitaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Receita não encontrada"));
    }

    public Receita salvar(ReceitaDTO receitaDto) {
        Optional<Usuario> usuario = usuarioRepository.findById(receitaDto.getUsuarioId());

        Receita receita = new Receita();
        receita.setNome(receitaDto.getNome());
        receita.setDescricao(receitaDto.getDescricao());
        receita.setModoPreparo(receitaDto.getModoPreparo());
        receita.setTempoEmMinutos(receitaDto.getTempoEstimado());
        receita.setCategoria(receitaDto.getCategoria());
        receita.setPorcoes(receitaDto.getPorcoes());
        if(usuario.isPresent())
            receita.setUsuario(usuario.get());

        receitaDto.getIngredientes().forEach(ingredienteReceitaDTO -> {
             Ingrediente ingrediente = ingredienteService.encontrarOuCriarPornome(ingredienteReceitaDTO.getNome());
            IngredienteReceita ingredienteReceita = new IngredienteReceita();
            ingredienteReceita.setIngrediente(ingrediente);
            ingredienteReceita.setReceita(receita);
            ingredienteReceita.setQuantidade(ingredienteReceitaDTO.getQuantidade());
            ingredienteReceita.setMedida(ingredienteReceitaDTO.getMedida());
            receita.getIngredientes().add(ingredienteReceita);
        });

        return receitaRepository.save(receita);
    }

    public List<Receita> buscar(PesquisaDTO pesquisaDTO) {

        return receitaRepository.findByCategoriaAndNomeContainingIgnoreCase(pesquisaDTO.getCategoria(), pesquisaDTO.getNome());
    }

    public void favoritar(Long id) {
        Receita receita = this.findById(id);
        receita.setFavorito(!receita.isFavorito());
        receitaRepository.save(receita);
    }
}

