package org.example.recipehub.model.enums;

public enum Medida {

    GRAMA("Grama"),
    COLHER_SOPA("Colher de Sopa"),
    COLHER_CHA("Colher de Chá"),
    XICARA("Xícara"),
    MILILITRO("Mililitro"),
    LITRO("Litro"),
    COPO("Copo"),
    FATIA("Fatia"),
    PITADA("Pitada"),
    RAMO("Ramo"),
    FOLHA("Folha"),
    DENTE("Dente"),
    GOTA("Gota"),
    FILE("Filé"),
    PEDACO("Pedaço"),
    RAMA("Rama"),
    BANDEJA("Bandeja"),
    PACOTE("Pacote"),
    LATA("Lata"),
    POTE("Pote"),
    BARRA("Barra"),
    UNIDADE("Unidade"),
    UNIDADE_PEQUENA("Unidade Pequena"),
    UNIDADE_MEDIA("Unidade Média"),
    UNIDADE_GRANDE("Unidade Grande"),
    A_GOSTO("A Gosto");

    private final String descricao;

    Medida(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
