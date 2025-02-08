package com.esther.mengo.mengaostats.model;

import java.time.LocalDateTime;

public class News {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime publicationDate;

    public News() {
    }

    public News(String title, String content, LocalDateTime publicationDate) {
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }
}
