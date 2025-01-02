package com.esther.mengo.mengaostats.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table (name = "tb_jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @ManyToMany
    private List<Jogador> jogadoresDisponiveis;

    public Jogo() {

    }

    public Jogo(Long id, LocalDate data, List<Jogador> jogadoresDisponiveis) {
        this.id = id;
        this.data = data;
        this.jogadoresDisponiveis = jogadoresDisponiveis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Jogador> getJogadoresDisponiveis() {
        return jogadoresDisponiveis;
    }

    public void setJogadoresDisponiveis(List<Jogador> jogadoresDisponiveis) {
        this.jogadoresDisponiveis = jogadoresDisponiveis;
    }
}

