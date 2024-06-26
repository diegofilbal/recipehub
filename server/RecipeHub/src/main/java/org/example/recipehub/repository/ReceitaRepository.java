package org.example.recipehub.repository;

import org.example.recipehub.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    @Query("SELECT r FROM Receita r WHERE r.usuario.id = ?1 OR r.usuario.id = 1 ORDER BY r.criadoEm DESC LIMIT 6")
    List<Receita> findTop6ByUsuarioIdOrderByCriadoEmDesc(Long usuarioId);

    @Query("SELECT r FROM Receita r WHERE r.usuario.id = ?1 AND r.favorito = true ORDER BY r.criadoEm  LIMIT 6")
    List<Receita> findTop6ByFavoritoTrueAndUsuarioIdOrderByCriadoEmDesc(Long usuarioId);

    List<Receita> findByUsuarioLogin(String login);
}