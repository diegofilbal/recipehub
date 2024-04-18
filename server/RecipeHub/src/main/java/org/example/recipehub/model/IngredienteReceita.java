package org.example.recipehub.model;

import jakarta.persistence.*;
import org.example.recipehub.model.enums.Medida;

@Entity
@Table(name = "ingrediente_receita", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ingrediente_id", "receita_id"})
})
public class IngredienteReceita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Receita receita;

    private float quantidade;

    @Enumerated(EnumType.STRING)
    private Medida medida;

    public IngredienteReceita() {
    }

    public IngredienteReceita(Ingrediente ingrediente, Receita receita, float quantidade, Medida medida) {
        this.ingrediente = ingrediente;
        this.receita = receita;
        this.quantidade = quantidade;
        this.medida = medida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
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
