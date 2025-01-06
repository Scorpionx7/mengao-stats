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

    private String adversario;
    private String resultado;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "competicao_id", nullable = false)
    private Competicao competicao;


    @ManyToMany
    @JoinTable(
            name = "jogos_jogadores",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "jogador_id")
    )
    private List<Jogador> jogadoresDisponiveis;

    public Jogo() {

    }

    public Jogo(Long id, String adversario, String resultado, LocalDate data, Competicao competicao, List<Jogador> jogadoresDisponiveis) {
        this.id = id;
        this.adversario = adversario;
        this.resultado = resultado;
        this.data = data;
        this.competicao = competicao;
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

    public String getAdversario() {
        return adversario;
    }

    public void setAdversario(String adversario) {
        this.adversario = adversario;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }
}

