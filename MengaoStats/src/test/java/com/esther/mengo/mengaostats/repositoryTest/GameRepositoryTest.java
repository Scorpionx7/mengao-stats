package com.esther.mengo.mengaostats.repositoryTest;

import com.esther.mengo.mengaostats.model.Competition;
import com.esther.mengo.mengaostats.model.Game;
import com.esther.mengo.mengaostats.repository.GameRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class GameRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void whenFindByCompetitionId_thenReturnGames() {
        // Dado
        Competition competition = new Competition("Brasileirão", "2023");
        entityManager.persist(competition);
        entityManager.flush();

        Game game = new Game(competition, LocalDateTime.now(), "Flamengo", "Vasco");
        entityManager.persist(game);
        entityManager.flush();

        // Quando
        List<Game> foundGames = gameRepository.findByCompetitionId(competition.getId());

        // Então
        assertThat(foundGames).hasSize(1);
        assertThat(foundGames.get(0).getHomeTeam()).isEqualTo(game.getHomeTeam());
    }
}
