package org.example.recipehub.model.dto;

import org.example.recipehub.model.Medida;

public class IngredienteReceitaDTO {

    private Long id;
    private String nome;
    private float quantidade;
    private Medida medida;

    public IngredienteReceitaDTO() {}

    public IngredienteReceitaDTO(Long id, String nome, float quantidade, Medida medida) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.medida = medida;
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

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }
}
