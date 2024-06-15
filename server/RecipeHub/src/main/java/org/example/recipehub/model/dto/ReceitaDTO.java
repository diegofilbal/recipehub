package org.example.recipehub.model.dto;

import org.example.recipehub.model.Categoria;

import java.util.List;

public class ReceitaDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String modoPreparo;
    private int tempoEstimado;
    private List<IngredienteReceitaDTO> ingredientes;
    private Categoria categoria;

    private int porcoes;

    private Long usuarioId;

    public ReceitaDTO() {}


    public ReceitaDTO(Long id, String nome, String descricao, String modoPreparo,
                      int tempoEstimado, List<IngredienteReceitaDTO> ingredientes,
                      Categoria categoria, int porcoes, Long usuarioId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.modoPreparo = modoPreparo;
        this.tempoEstimado = tempoEstimado;
        this.ingredientes = ingredientes;
        this.categoria = categoria;
        this.porcoes = porcoes;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public List<IngredienteReceitaDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteReceitaDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getPorcoes() {
        return porcoes;
    }

    public void setPorcoes(int porcoes) {
        this.porcoes = porcoes;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
