package com.esther.mengo.mengaostats.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String posicao;
    private boolean estaDisponivel;
    private boolean suspenso;
    private boolean lesionado;
    private boolean contratado;
    private boolean negocioado;

    public Jogador() {

    }

    public Jogador(Long id, String nome, String posicao, boolean estaDisponivel, boolean suspenso,
                   boolean lesionado, boolean contratado, boolean negocioado) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.estaDisponivel = estaDisponivel;
        this.suspenso = suspenso;
        this.lesionado = lesionado;
        this.contratado = contratado;
        this.negocioado = negocioado;
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

    public boolean isEstaDisponivel() {
        return estaDisponivel;
    }

    public void setEstaDisponivel(boolean estaDisponivel) {
        this.estaDisponivel = estaDisponivel;
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


}
