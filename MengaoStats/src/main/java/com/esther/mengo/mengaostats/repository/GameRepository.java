package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    //Metodo para buscar jogos por competição
    List<Game> findByCompetitionId(Long competitionId);

}
