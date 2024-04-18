package org.example.recipehub.model.dto;

import org.example.recipehub.model.Receita;
import org.example.recipehub.model.enums.Categoria;

import java.util.ArrayList;
import java.util.List;

public class ReceitaDTO {

    private Long id;
    private String nome;
    private Categoria categoria;
    private String descricao;
    private String modoPreparo;
    private int tempoEstimado;
    private String observacao;
    private List<IngredienteDTO> ingredientes = new ArrayList<>();

    public ReceitaDTO() {
    }

    public ReceitaDTO(Long id, String nome, Categoria categoria, String descricao, String modoPreparo, int tempoEstimado, String observacao, List<IngredienteDTO> ingredientes) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.modoPreparo = modoPreparo;
        this.tempoEstimado = tempoEstimado;
        this.observacao = observacao;
        this.ingredientes = ingredientes;
    }

    public ReceitaDTO(Receita receita) {
        if (receita != null) {
            this.id = receita.getId();
            this.nome = receita.getNome();
            this.categoria = receita.getCategoria();
            this.descricao = receita.getDescricao();
            this.modoPreparo = receita.getModoPreparo();
            this.tempoEstimado = receita.getTempoEstimado();
            this.observacao = receita.getObservacao();
            this.ingredientes = receita.getIngredientes().stream().map(IngredienteDTO::new).toList();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
