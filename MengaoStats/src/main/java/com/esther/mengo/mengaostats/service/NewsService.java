package com.esther.mengo.mengaostats.service;

import com.esther.mengo.mengaostats.model.News;

import java.util.List;

public interface NewsService {

    List<News> getAllNews();
    News getNewsById(Long id);
    News createNews(News news);
    News updateNews(Long id, News news);
    void deleteNews(Long id);
}
