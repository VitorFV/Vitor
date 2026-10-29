package com.api.simulado.repository;

import com.api.simulado.models.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel,Integer> {

    Optional<EstoqueModel> findById(Integer id);
    Optional<EstoqueModel> findAllById(Integer id);