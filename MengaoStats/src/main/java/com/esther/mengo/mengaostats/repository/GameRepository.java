package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    //Metodo para buscar jogos por competição
    List<Game> findByCompetitionId(Long competitionId);
    List<Game> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    Page<Game> findAll(Pageable pageable);

}
