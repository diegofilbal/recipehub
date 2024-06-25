package org.example.recipehub.service;

import org.example.recipehub.model.Usuario;
import org.example.recipehub.model.dto.UsuarioDTO;
import org.example.recipehub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<UsuarioDTO> listar() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO detalhar(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).orElse(null));
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDto) throws Exception {
        if (usuarioRepository.findByLogin(usuarioDto.getLogin()).isPresent()) {
            throw new Exception("Já existe um usuário com este login.");
        }
        usuarioDto.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));
        Usuario novoUsuario = new Usuario(usuarioDto.getNome(), usuarioDto.getLogin(), usuarioDto.getSenha(), usuarioDto.getEmail());
        return new UsuarioDTO(usuarioRepository.save(novoUsuario));
    }


    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new Usuario(
                user.getId(),
                user.getLogin(),
                user.getSenha(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }

    public Usuario atualizar(UsuarioDTO usuarioDto) throws Exception {
        Usuario usuario = usuarioRepository.findById(usuarioDto.getId())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com id: " + usuarioDto.getId()));

        if (!usuario.getLogin().equals(usuarioDto.getLogin()) && usuarioRepository.findByLogin(usuarioDto.getLogin()).isPresent()) {
            throw new Exception("Já existe um usuário com este login.");
        }

        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setLogin(usuarioDto.getLogin());

        if (usuarioDto.getSenha() != null && !usuarioDto.getSenha().isEmpty()) {
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuarioDto.getSenha()));
        }

        return usuarioRepository.save(usuario);
    }

}
