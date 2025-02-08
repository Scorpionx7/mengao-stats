package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.model.Competition;
import com.esther.mengo.mengaostats.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class GameRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GameRepository gameRepository;

    public void whenFindByCompetitionId_thenReturnGame() {
        //Dado
        Competition competition = new Competition("Brasileirão", "2023");
        entityManager.persist(competition);

        Game game = new Game(competition, LocalDateTime.now(), "Flameng", "Vasco");
        entityManager.persist(game);
        entityManager.flush();

        // Quando

        List<Game> foundGames = gameRepository.findByCompetitionId(competition.getId());

        // Então
        assertThat(foundGames).hasSize(1);
        assertThat(foundGames.get(0).getHomeTeam()).isEqualTo(game.getHomeTeam());

    }
}
