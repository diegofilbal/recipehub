package org.example.recipehub.model;

public enum Medida {
    GRAMAS("Gramas"),
    COLHER_DE_CHA("Colher(es) de chá"),
    COLHER_DE_SOPA("Colher(es) de sopa"),
    XICARA("Xícara(s)"),
    UNIDADE("Unidade(s)"),
    ML("mililitro(s)"),
    LITRO("litro(s)");

    private final String descricao;

    Medida(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
