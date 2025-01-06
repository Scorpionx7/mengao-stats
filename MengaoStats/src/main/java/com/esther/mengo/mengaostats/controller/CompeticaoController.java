package com.esther.mengo.mengaostats.controller;

import com.esther.mengo.mengaostats.entity.Competicao;
import com.esther.mengo.mengaostats.service.CompeticaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competicoes")
@RequiredArgsConstructor
public class CompeticaoController {

    private final CompeticaoService competicaoService;

    // 1. Listar todas as competições
    @GetMapping
    public ResponseEntity<List<Competicao>> listarTodas(){
        List<Competicao> competicoes = competicaoService.listarTodas();
        return ResponseEntity.ok(competicoes);
    }

    // 2. Adicionar uma nova competicao
    @PostMapping
    public ResponseEntity<Competicao> adicionar(@RequestBody Competicao competicao){
        Competicao novaCompeticao = competicaoService.adicionar(competicao);
        return ResponseEntity.ok(novaCompeticao);
    }

    //3. Remover uma competição
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        competicaoService.remover(id);
        return ResponseEntity.noContent().build();
    }




}
