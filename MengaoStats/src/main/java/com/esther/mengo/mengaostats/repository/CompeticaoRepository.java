package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.entity.Competicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Long> {

}
