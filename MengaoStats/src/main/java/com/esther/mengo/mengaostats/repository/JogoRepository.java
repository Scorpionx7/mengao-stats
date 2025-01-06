package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {


}
