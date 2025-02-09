package com.esther.mengo.mengaostats.service.implement;

import com.esther.mengo.mengaostats.model.News;
import com.esther.mengo.mengaostats.repository.NewsRepository;
import com.esther.mengo.mengaostats.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(Long id) {
        Optional<News> news = newsRepository.findById(id);
        return news.orElseThrow(() -> new RuntimeException("News not found with id: " + id));
    }

    @Override
    public News createNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News updateNews(Long id, News news) {
        News existingNews = getNewsById(id);
        existingNews.setTitle(news.getTitle());
        existingNews.setContent(news.getContent());
        existingNews.setPublicationDate(news.getPublicationDate());
        return newsRepository.save(existingNews);
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
