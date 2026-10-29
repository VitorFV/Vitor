package com.api.simulado.controller;

import com.api.simulado.dto.EstoqueDto;
import com.api.simulado.models.EstoqueModel;
import com.api.simulado.repository.EstoqueRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/agendamento")

public class EstoqueController {

    @Autowired
    EstoqueRepository estoqueRepository;

    @PostMapping
    public ResponseEntity<EstoqueModel> save(@RequestBody @Valid EstoqueDto estoqueDto){
        var agendamentoModel = new EstoqueModel();
        BeanUtils.copyProperties(estoqueDto, estoqueModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueRepository.save(estoqueModel));
    }
    @GetMapping
    public ResponseEntity<List<EstoqueModel>>getAllEstoque(){
        return ResponseEntity.status(HttpStatus.OK).body(estoqueRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarUmEstoque(@PathVariable(value = "id")int id){
        Optional<EstoqueModel> estoqu0 = estoqueRepository.findById(id);
        if(estoqu0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estoque Não Encontro");
        }
        return ResponseEntity.status(HttpStatus.OK).body(estoqu0.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object>atualizacaoEstoque(@PathVariable(value = "id")int id,
                                                        @RequestBody @Valid EstoqueDto estoqueDto){
        Optional<EstoqueModel> agendament0 = estoqueRepository.findAllById(id);
        if(agendament0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estoque Não encontrado");
        }
        var estoqueModel = estoqu0.get();
        BeanUtils.copyProperties(estoqueDto, estoqueModel);
        return ResponseEntity.status(HttpStatus.OK).body(estoqueRepository.save(agendamentoModel));
    }
}
