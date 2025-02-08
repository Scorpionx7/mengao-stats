package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    // Metodo para buscar competicao por nome
    Competition findByName(String name);

}
