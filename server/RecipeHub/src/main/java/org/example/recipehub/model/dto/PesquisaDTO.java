package org.example.recipehub.model.dto;

import org.example.recipehub.model.Categoria;

public class PesquisaDTO {

    private Categoria categoria;
    private String nome;

    public PesquisaDTO() {}

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
