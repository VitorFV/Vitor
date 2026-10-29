package com.api.simulado.controller;

import com.api.simulado.dto.UsuarioDto;
import com.api.simulado.models.UsuarioModel;
import com.api.simulado.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cliente")

public class UsuarioController {
    @Autowired
    UsuarioRepository clienteRepository;

    @PostMapping
    public ResponseEntity<UsuarioModel> save(@RequestBody @Valid UsuarioDto clienteDto){
        var clienteModel = new UsuarioModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteModel));
    }
}
