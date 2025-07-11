package com.esther.mengo.mengaostats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Integer externalId;

    @ManyToOne
    @NotNull(message = "Competition is required")
    private Competition competition;
    @NotNull(message = "Date is required")
    private LocalDateTime date;
    @Size(min = 1, max = 100, message = "Home team name must be between 1 and 100 characters")
    @NotNull(message = "Home team is required")
    private String homeTeam;
    @Size(min = 1, max = 100, message = "Away team name must be between 1 and 100 characteres")
    @NotNull(message = "Away team is required")
    private String awayTeam;

    private Integer homeScore;
    private Integer awayScore;


    public Game() {
    }

    public Game(Competition competition, LocalDateTime date, String homeTeam, String awayTeam) {
        this.competition = competition;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }
}
