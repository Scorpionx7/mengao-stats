package com.esther.mengo.mengaostats.service.implement;

import com.esther.mengo.mengaostats.model.Player;
import com.esther.mengo.mengaostats.repository.PlayerRepository;
import com.esther.mengo.mengaostats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerId (Long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.orElseThrow(()-> new RuntimeException("Player not found with id " + id));
    }

    @Override
    public Player createPlayer (Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Player player, Long id){
        Player existingPlayer = getPlayerId(id);
        existingPlayer.setName(player.getName());
        existingPlayer.setPosition(player.getPosition());
        existingPlayer.setAge(player.getAge());
        existingPlayer.setNumber(player.getNumber());
        return playerRepository.save(existingPlayer);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
