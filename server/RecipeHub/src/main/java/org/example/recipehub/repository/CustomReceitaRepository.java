package org.example.recipehub.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.recipehub.model.Categoria;
import org.example.recipehub.model.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomReceitaRepository {

    @Autowired
    private EntityManager em;

    public List<Receita> findReceitasByCategoriaAndNome(String categoria, String nome) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Receita> cq = cb.createQuery(Receita.class);
        Root<Receita> receita = cq.from(Receita.class);

        List<Predicate> predicates = buildPredicates(cb, receita, categoria, nome);

        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        return em.createQuery(cq).getResultList();
    }

    private List<Predicate> buildPredicates(CriteriaBuilder cb, Root<Receita> root, String categoria, String nome) {
        List<Predicate> predicates = new ArrayList<>();
        if (categoria != null) {
            predicates.add(cb.equal(root.get("categoria"), Categoria.valueOf(categoria)));
        }
        if (nome != null) {
            predicates.add(cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%"));
        }
        return predicates;
    }
}