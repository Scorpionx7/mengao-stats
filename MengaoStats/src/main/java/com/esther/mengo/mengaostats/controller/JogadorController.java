package com.esther.mengo.mengaostats.controller;

import com.esther.mengo.mengaostats.entity.Jogador;
import com.esther.mengo.mengaostats.service.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
@RequiredArgsConstructor
public class JogadorController {

    private final JogadorService jogadorService;

    // 1. Listar todos os jogadores
    @GetMapping
    public ResponseEntity<List<Jogador>> listarTodos(){
        List<Jogador> jogadores = jogadorService.listarTodos();
        return ResponseEntity.ok(jogadores);
    }

    // 2. Buscar jogador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarPorId (@PathVariable Long id){
        Jogador jogador = jogadorService.buscarPorId(id);
        return ResponseEntity.ok(jogador);
    }


    // 3. Adicionar um jogador
    @PostMapping
    public ResponseEntity<Jogador> adicionar(@RequestBody Jogador jogador){
        Jogador novoJogador = jogadorService.salvar(jogador);
        return ResponseEntity.ok(novoJogador);
    }

    // 4. Atualizar informações de um jogador
    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizar(@PathVariable Long id, @RequestBody Jogador jogador){
        Jogador jogadorAtualizado = jogadorService.atualizar(id, jogador);
        return ResponseEntity.ok(jogadorAtualizado);
    }

    // 5. Deletar um jogador
    @DeleteMapping("/{id}")
    public ResponseEntity<Jogador> deletar(@PathVariable Long id){
        jogadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // 6. Listar jogadores por status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Jogador>> listarPorStatus(@PathVariable String status){
        List<Jogador> jogadores = jogadorService.listarPorStatus(status);
        return ResponseEntity.ok(jogadores);
    }

    // 7. Consultar estatisticas de um jogador
    @GetMapping("/{id}/estatisticas")
    public ResponseEntity<?> consultarEstatisticas(@PathVariable Long id){
        Object estatisticas = jogadorService.consultarEstatísticas(id);
        return ResponseEntity.ok(estatisticas);
    }







}
