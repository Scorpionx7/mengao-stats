package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    List<Jogador> findByStatus(String status);
}
