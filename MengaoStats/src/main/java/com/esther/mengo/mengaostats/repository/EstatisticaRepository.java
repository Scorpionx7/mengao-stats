package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.entity.Estatistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EstatisticaRepository extends JpaRepository<Estatistica, Long> {

    List<Estatistica> findByJogadorId(Long jogadorId);
}
