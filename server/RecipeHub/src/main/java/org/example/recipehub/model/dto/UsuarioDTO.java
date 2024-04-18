package org.example.recipehub.model.dto;

import org.example.recipehub.model.Usuario;

import java.util.List;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private List<ReceitaDTO> receitas;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome, String login, String senha, String email, List<ReceitaDTO> receitas) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.receitas = receitas;
    }

    public UsuarioDTO(Usuario usuario) {
        if (usuario != null) {
            id = usuario.getId();
            nome = usuario.getNome();
            login = usuario.getLogin();
            senha = usuario.getSenha();
            email = usuario.getEmail();
            receitas = usuario.getReceitas().stream().map(ReceitaDTO::new).toList();
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ReceitaDTO> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<ReceitaDTO> receitas) {
        this.receitas = receitas;
    }
}
