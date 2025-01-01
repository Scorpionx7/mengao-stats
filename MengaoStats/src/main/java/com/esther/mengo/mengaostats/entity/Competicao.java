package com.esther.mengo.mengaostats.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table (name = "tb_competicoes")
public class Competicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate ano;

    public Competicao() {

    }

    public Competicao(Long id, String nome, LocalDate ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
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
}
