package com.esther.mengo.mengaostats.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table (name = "tb_estatistica")
public class Estatistica {

    @ManyToOne
    private Jogador jogador;
    private int gols;
    private int assistencias;

    public Estatistica(){

    }

    public Estatistica(Jogador jogador, int gols, int assistencias) {
        this.jogador = jogador;
        this.gols = gols;
        this.assistencias = assistencias;
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
}

