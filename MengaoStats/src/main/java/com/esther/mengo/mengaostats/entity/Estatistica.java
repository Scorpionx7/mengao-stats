package com.esther.mengo.mengaostats.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "tb_estatistica")
public class Estatistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jogador_id")
    private Jogador jogador;
    private int gols;
    private int assistencias;
    private int cartoesAmarelos;
    private int cartoesVermelhos;

    public Estatistica(){

    }

    public Estatistica(Long id, Jogador jogador, int gols, int assistencias, int cartoesAmarelos, int cartoesVermelhos) {
        this.id = id;
        this.jogador = jogador;
        this.gols = gols;
        this.assistencias = assistencias;
        this.cartoesAmarelos = cartoesAmarelos;
        this.cartoesVermelhos = cartoesVermelhos;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    public void setCartoesAmarelos(int cartoesAmarelos) {
        this.cartoesAmarelos = cartoesAmarelos;
    }

    public int getCartoesVermelhos() {
        return cartoesVermelhos;
    }

    public void setCartoesVermelhos(int cartoesVermelhos) {
        this.cartoesVermelhos = cartoesVermelhos;
    }
}

