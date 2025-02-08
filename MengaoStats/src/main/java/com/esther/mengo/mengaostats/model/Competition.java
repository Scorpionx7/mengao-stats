package com.esther.mengo.mengaostats.model;

public class Competition {
    private Long id;
    private String name;
    private String season;

    public Competition() {
    }

    public Competition(String name, String season) {
        this.name = name;
        this.season = season;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
