package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    List<Jogo> findByCompeticaoId(Long competicaoId);


}
