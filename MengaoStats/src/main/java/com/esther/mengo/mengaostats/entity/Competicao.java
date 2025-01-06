package com.esther.mengo.mengaostats.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table (name = "tb_competicoes")
public class Competicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate ano;

    @OneToMany(mappedBy = "competicao", cascade = CascadeType.ALL)
    private List<Jogo> jogos;

    public Competicao() {

    }

    public Competicao(Long id, String nome, LocalDate ano, List<Jogo> jogos) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
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

    public LocalDate getAno() {
        return ano;
    }

    public void setAno(LocalDate ano) {
        this.ano = ano;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
}
