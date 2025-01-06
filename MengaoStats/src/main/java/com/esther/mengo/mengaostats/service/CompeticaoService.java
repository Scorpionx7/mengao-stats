package com.esther.mengo.mengaostats.service;

import com.esther.mengo.mengaostats.entity.Competicao;
import com.esther.mengo.mengaostats.entity.Jogador;
import com.esther.mengo.mengaostats.entity.Jogo;
import com.esther.mengo.mengaostats.repository.CompeticaoRepository;
import com.esther.mengo.mengaostats.repository.JogoRepository;
import jakarta.persistence.SecondaryTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Nodes.collect;

@Service
@RequiredArgsConstructor
public class CompeticaoService {

    private final CompeticaoRepository competicaoRepository;
    private final JogoRepository jogoRepository;

    // 1 .Listar todas as competições
    public List<Competicao> listarTodas(){
        return competicaoRepository.findAll();
    }

    // 2. Adicionar uma nova competição
    public Competicao adicionar(Competicao competicao){
        return competicaoRepository.save(competicao);
    }

    //3. Atualizar informações de uma competicação
    public Competicao atualizar(Long id, Competicao competicaoAtualizada){
        Competicao competicao = buscarPorId(id);
        competicao.setNome(competicaoAtualizada.getNome());
        competicao.setJogos(competicaoAtualizada.getJogos());
        return competicaoRepository.save(competicao);
    }

    //4. Remover uma competicao

    public void remover(Long id){
        Competicao competicao = buscarPorId(id);
        competicaoRepository.delete(competicao);
    }

    //5. Listar detalhes da competição
    public Object listarDetalhes(Long id){
        Competicao competicao = buscarPorId(id);

        List<Jogo> jogos = jogoRepository.findByCompeticaoId(id);

        Map<Long, Jogador> jogadoresMap = new HashMap<>();
        for (Jogo jogo : jogos) {
            for (Jogador jogador : jogo.getJogadoresDisponiveis()) {
                jogadoresMap.put(jogador.getId(), jogador);
            }
        }

        Map<String, Object> detalhes = new HashMap<>();
        detalhes.put("competicao", competicao.getNome());
        detalhes.put("jogos", jogos);
        detalhes.put("jogadores", jogadoresMap.values());

        return detalhes;
    }

    // Método auxiliar para buscar competicao por ID
    private Competicao buscarPorId (Long id){
        return competicaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competicação não encontrada com o ID:  " + id));
    }

}
