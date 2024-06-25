package org.example.recipehub.service;

import org.example.recipehub.model.Usuario;
import org.example.recipehub.model.dto.UsuarioDTO;
import org.example.recipehub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listar() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO detalhar(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).orElse(null));
    }

    public UsuarioDTO salvar(UsuarioDTO usuario) {
        Usuario novoUsuario = new Usuario(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getEmail());
        return new UsuarioDTO(usuarioRepository.save(novoUsuario));
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.withUsername(user.getLogin())
                .password(user.getSenha())
                .roles("USER")
                .build();
    }
}
