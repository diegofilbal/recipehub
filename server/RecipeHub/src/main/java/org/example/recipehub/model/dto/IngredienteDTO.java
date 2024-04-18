package org.example.recipehub.model.dto;

import org.example.recipehub.model.Ingrediente;

public class IngredienteDTO {

    private Long id;
    private String nome;

    public IngredienteDTO() {
    }

    public IngredienteDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public IngredienteDTO(Ingrediente ingrediente) {
        if (ingrediente != null) {
            this.id = ingrediente.getId();
            this.nome = ingrediente.getNome();
        }
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
}
