package org.example.recipehub.repository;

import org.example.recipehub.model.IngredienteReceita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteReceitaRepository extends JpaRepository<IngredienteReceita, Long> {
}
