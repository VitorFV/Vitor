package com.api.simulado.repository;

import com.api.simulado.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel,Integer> {

    Optional<ProdutoModel> findById(Integer id);
    Optional<ProdutoModel> findAllById(Integer id);
}
