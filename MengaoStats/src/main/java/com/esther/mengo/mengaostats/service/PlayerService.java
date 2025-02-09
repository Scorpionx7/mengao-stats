package com.esther.mengo.mengaostats.service;

import com.esther.mengo.mengaostats.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayers();
    Player getPlayerId(Long id);
    Player createPlayer(Player player);
    Player updatePlayer(Player player, Long id);
    void deletePlayer(Long id);
}
