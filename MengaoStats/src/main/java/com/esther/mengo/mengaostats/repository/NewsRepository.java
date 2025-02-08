package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    // metodo para buscar noticias por intervalo de datas
    List<News> findByPublicationDateBetween(LocalDate startDate, LocalDate endDate);

}
