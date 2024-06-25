package org.example.recipehub.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.recipehub.model.Usuario;

public class UsuarioDTO {

    private Long id;
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 100, message = "Nome não pode ter mais que 255 caracteres")
    private String nome;

    @NotBlank(message = "Login não pode ser vazio")
    @Size(max = 15, message = "Login não pode ter mais que 10 caracteres")
    private String login;

    @NotBlank(message = "Senha não pode ser vazia")
    @Size(max = 15, message = "Senha não pode ter mais que 15 caracteres")
    private String senha;
    private String email;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome, String login, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public UsuarioDTO(Usuario usuario) {
        if (usuario != null) {
            id = usuario.getId();
            nome = usuario.getNome();
            login = usuario.getLogin();
            senha = usuario.getSenha();
            email = usuario.getEmail();
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
}
