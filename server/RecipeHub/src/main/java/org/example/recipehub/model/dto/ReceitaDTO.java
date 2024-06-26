package org.example.recipehub.model.dto;

import jakarta.validation.constraints.*;
import org.example.recipehub.model.Categoria;

import java.util.List;

public class ReceitaDTO {
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 255, message = "Nome não pode ter mais que 255 caracteres")
    private String nome;

    @NotBlank(message = "Descrição não pode ser vazia")
    @Size(max = 1000, message = "Descrição não pode ter mais que 1000 caracteres")
    private String descricao;

    @NotBlank(message = "Modo de preparo não pode ser vazio")
    @Size(max = 2000, message = "Descrição não pode ter mais que 2000 caracteres")
    private String modoPreparo;

    @Min(value = 1, message = "Tempo estimado deve ser no mínimo 1 minuto")
    private int tempoEstimado;

    @NotNull(message = "Receita deve conter pelo menos um ingrediente")
    private List<IngredienteReceitaDTO> ingredientes;

    @NotNull(message = "Categoria não pode ser nula")
    private Categoria categoria;

    @Min(value = 1, message = "Porções deve ser no mínimo 1")
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
