package com.esther.mengo.mengaostats.controller;

import com.esther.mengo.mengaostats.model.News;
import com.esther.mengo.mengaostats.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        List<News> newsList = newsService.getAllNews();
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        News news = newsService.getNewsById(id);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<News> createNews(@RequestBody News news) {
        News createdNews = newsService.createNews(news);
        return new ResponseEntity<>(createdNews, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News news) {
        News updatedNews = newsService.updateNews(id, news);
        return new ResponseEntity<>(updatedNews, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
