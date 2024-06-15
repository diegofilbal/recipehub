package org.example.recipehub.repository;

import org.example.recipehub.model.Categoria;
import org.example.recipehub.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findByCategoriaAndNomeContainingIgnoreCase(Categoria categoria, String nome);
}