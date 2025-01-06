package com.esther.mengo.mengaostats.service;

import com.esther.mengo.mengaostats.entity.Estatistica;
import com.esther.mengo.mengaostats.entity.Jogador;
import com.esther.mengo.mengaostats.repository.EstatisticaRepository;
import com.esther.mengo.mengaostats.repository.JogadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final EstatisticaRepository estatisticaRepository;

   // 1. Listar todos os jogadores
    public List<Jogador> listarTodos(){
        return jogadorRepository.findAll();
    }

    // 2. Buscar jogador por ID
    public Jogador buscarPorId(Long id){
        return jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado com ID: " + id));

    }

    // 3. Adicionar um jogador
    public Jogador salvar (Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    // 4. Atualizar informações de um jogador
    public Jogador atualizar(Long id, Jogador jogadorAtualizado){
        Jogador jogadorExistente = buscarPorId(id);
        jogadorExistente.setNome(jogadorAtualizado.getNome());
        jogadorExistente.setPosicao(jogadorAtualizado.getPosicao());
        jogadorExistente.setContratado(jogadorAtualizado.isContratado());
        jogadorExistente.setSuspenso(jogadorAtualizado.isSuspenso());
        // continuar os campos
        return jogadorRepository.save(jogadorExistente);
    }

    // 5. Deletar um jogador
    public void deletar(Long id){
        Jogador jogador = buscarPorId(id);
        jogadorRepository.delete(jogador);
    }

    // 6. Listar jogadores por status (machucados, suspensos, etc.)
    public List<Jogador> listarPorStatus(String status){
        return jogadorRepository.findByStatus(status);
    }

    //7. Consultar estatísticas de um jogador
    public Object consultarEstatísticas(Long id){
        Jogador jogador = buscarPorId(id);

        List<Estatistica> estatisticas = estatisticaRepository.findByJogadorId(id);

        return estatisticas.stream()
                .map(estatistica -> {
                    return Map.of(
                            "gols", estatistica.getGols(),
                            "assistencias",estatistica.getAssistencias(),
                            "cartoesAmarelos",estatistica.getCartoesAmarelos(),
                            "cartoesVermelhos", estatistica.getCartoesVermelhos()

                    );
                })
                .toList();
    }


}
