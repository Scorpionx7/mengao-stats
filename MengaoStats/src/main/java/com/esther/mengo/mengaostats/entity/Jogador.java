package com.esther.mengo.mengaostats.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String posicao;
    private boolean status;
    private boolean suspenso;
    private boolean lesionado;
    private boolean contratado;
    private boolean negocioado;

    @ManyToMany(mappedBy = "jogadores")
    private List<Jogo> jogos;

    public Jogador() {

    }

    public Jogador(Long id, String nome, String posicao, boolean status, boolean suspenso, boolean lesionado, boolean contratado, boolean negocioado, List<Jogo> jogos) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.status = status;
        this.suspenso = suspenso;
        this.lesionado = lesionado;
        this.contratado = contratado;
        this.negocioado = negocioado;
        this.jogos = jogos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }

    public boolean isLesionado() {
        return lesionado;
    }

    public void setLesionado(boolean lesionado) {
        this.lesionado = lesionado;
    }

    public boolean isContratado() {
        return contratado;
    }

    public void setContratado(boolean contratado) {
        this.contratado = contratado;
    }

    public boolean isNegocioado() {
        return negocioado;
    }

    public void setNegocioado(boolean negocioado) {
        this.negocioado = negocioado;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
}
