package com.esther.mengo.mengaostats.service.sync;

import com.esther.mengo.mengaostats.dto.external.ApiFootballResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataSyncService {

    private static final Logger logger = LoggerFactory.getLogger(DataSyncService.class);
    private final RestTemplate restTemplate;


    @Value("${api.football.key}")
    private String apiKey;

    public DataSyncService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Scheduled(cron = "0 0 2 * * ?")
    public void syncTeamsData() {
        logger.info("Iniciando a sincronização de dados dos times...");

        // IDs da Liga Brasileira e do Flamengo na API-Football
        final int BRAZILIAN_LEAGUE_ID = 71;
        final int FLAMENGO_TEAM_ID = 127;
        final int SEASON = 2025; // Vamos pegar os dados da temporada atual

        // Montamos a URL da API externa
        String url = String.format("https://v3.football.api-sports.io/teams?league=%d&season=%d",
                BRAZILIAN_LEAGUE_ID, SEASON);

        // Criamos os headers da requisição, incluindo nossa chave da API
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        try {
            // Fazemos a chamada para a API
            ResponseEntity<ApiFootballResponseDTO> response = restTemplate.exchange(
                    url, HttpMethod.GET, entity, ApiFootballResponseDTO.class
            );

            // Verificamos se a resposta foi bem-sucedida
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                ApiFootballResponseDTO apiResponse = response.getBody();
                logger.info("Times recebidos da API: " + apiResponse.response().size());

                // **PRÓXIMO PASSO SERIA AQUI**:
                // 1. Iterar sobre apiResponse.response()
                // 2. Para cada time, verificar se ele já existe no nosso banco de dados.
                // 3. Se não existir, criar uma nova entidade (ex: Competition, Game) e salvar.
                // 4. Se já existir, atualizar os dados.

                // Por enquanto, vamos apenas logar o nome do primeiro time encontrado
                if (!apiResponse.response().isEmpty()) {
                    logger.info("Primeiro time encontrado: " + apiResponse.response().get(0).team().name());
                }

            } else {
                logger.error("Falha ao buscar dados da API. Status: " + response.getStatusCode());
            }

        } catch (Exception e) {
            logger.error("Erro ao tentar sincronizar dados dos times: " + e.getMessage(), e);
        }

        logger.info("Sincronização de dados dos times finalizada.");
    }
}
