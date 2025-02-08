package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    //Metodo para buscar jogadores por posicao
    List<Player> findByPosition(String position);

}
