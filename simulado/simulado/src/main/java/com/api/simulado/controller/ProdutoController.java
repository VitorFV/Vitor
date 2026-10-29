package com.api.simulado.controller;

import com.api.simulado.dto.ProdutoDto;
import com.api.simulado.models.ProdutoModel;
import com.api.simulado.repository.ProdutoRepository;
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
@RequestMapping("/api/produto")

public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<ProdutoModel> save(@RequestBody @Valid ProdutoDto produtoDto){
        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDto, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtoModel));
    }
    @GetMapping
    public ResponseEntity<List<ProdutoModel>>getAllProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarUmProduto(@PathVariable(value = "id")int id){
        Optional<ProdutoModel> produt0 = produtoRepository.findById(id);
        if(produt0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto Não Encontro");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produt0.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object>atualizacaoProduto(@PathVariable(value = "id")int id,
                                                    @RequestBody @Valid ProdutoDto produtoDto){
        Optional<ProdutoModel> produt0 = produtoRepository.findAllById(id);
        if(produt0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto Não encontrado");
        }
        var produtoModel = produt0.get();
        BeanUtils.copyProperties(produtoDto, produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produtoModel));
    }
}

