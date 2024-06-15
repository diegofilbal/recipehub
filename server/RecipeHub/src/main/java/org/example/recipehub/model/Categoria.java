package org.example.recipehub.model;

public enum Categoria {
    DOCES("Doces"),
    SALGADOS("Salgados"),
    VEGETARIANO("Vegetariano"),
    FRUTOS_DO_MAR("Frutos do Mar"),
    PEIXES("Peixes"),
    CARNES("Carnes"),
    AVES("Aves");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
