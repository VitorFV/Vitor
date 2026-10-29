package com.api.simulado.repository;

import com.api.simulado.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Integer> {

    Optional<UsuarioModel> findById(Integer id);
    Optional<UsuarioModel> findAllById(Integer id);
}

