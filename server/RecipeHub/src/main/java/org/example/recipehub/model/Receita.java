package org.example.recipehub.model;

import jakarta.persistence.*;
import org.example.recipehub.model.enums.Categoria;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(columnDefinition = "text")
    private String descricao;

    @Column(columnDefinition = "text")
    private String modoPreparo;

    private int tempoEstimado;

    @Column(columnDefinition = "text")
    private String observacao;

    @OneToMany(mappedBy = "receita")
    private List<IngredienteReceita> ingredienteReceitas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Receita() {
    }

    public Receita(String nome, Categoria categoria, String descricao, String modoPreparo, int tempoEstimado, String observacao, Usuario usuario) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.modoPreparo = modoPreparo;
        this.tempoEstimado = tempoEstimado;
        this.observacao = observacao;
        this.usuario = usuario;
    }

    public Receita(String nome, Categoria categoria, String descricao, String modoPreparo, int tempoEstimado, String observacao, List<IngredienteReceita> ingredienteReceitas, Usuario usuario) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.modoPreparo = modoPreparo;
        this.tempoEstimado = tempoEstimado;
        this.observacao = observacao;
        this.ingredienteReceitas = ingredienteReceitas;
        this.usuario = usuario;
    }

    public List<Ingrediente> getIngredientes() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        for (IngredienteReceita ir : ingredienteReceitas) {
            ingredientes.add(ir.getIngrediente());
        }
        return ingredientes;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<IngredienteReceita> getIngredienteReceitas() {
        return ingredienteReceitas;
    }

    public void setIngredienteReceitas(List<IngredienteReceita> ingredienteReceitas) {
        this.ingredienteReceitas = ingredienteReceitas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
