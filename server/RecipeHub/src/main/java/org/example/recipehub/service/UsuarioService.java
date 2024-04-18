package org.example.recipehub.service;

import org.example.recipehub.model.Usuario;
import org.example.recipehub.model.dto.UsuarioDTO;
import org.example.recipehub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listar() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO detalhar(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).orElse(null));
    }

    public UsuarioDTO salvar(Usuario usuario) {
        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

}
