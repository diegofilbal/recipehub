package org.example.recipehub.model.enums;

public enum Categoria {

    DOCE("Doce"),
    SALGADO("Salgado"),
    BEBIDA("Bebida"),
    VEGETARIANO("Vegetariano"),
    VEGANO("Vegano"),
    SEM_GLUTEN("Sem Glúten"),
    SEM_LACTOSE("Sem Lactose");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
