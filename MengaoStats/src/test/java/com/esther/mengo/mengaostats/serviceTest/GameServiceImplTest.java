package com.esther.mengo.mengaostats.serviceTest;

import com.esther.mengo.mengaostats.repository.GameRepository;
import com.esther.mengo.mengaostats.service.GameServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameServiceImplTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameServiceImpl gameService;
}
