package com.esther.mengo.mengaostats.service;

import com.esther.mengo.mengaostats.entity.Jogador;
import com.esther.mengo.mengaostats.repository.JogadorRepository;

import java.util.List;
import java.util.Optional;

public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService (JogadorRepository jogadorRepository){
        this.jogadorRepository = jogadorRepository;
    }

    public List<Jogador> listarTodos(){
        return jogadorRepository.findAll();
    }

    public Jogador salvar(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public Optional<Jogador> buscarPorId(Long id){
        return jogadorRepository.findById(id);
    }

}
