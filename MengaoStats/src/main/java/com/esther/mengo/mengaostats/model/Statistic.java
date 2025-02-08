package com.esther.mengo.mengaostats.model;

public class Statistic {

    private Long id;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
    private int tackles;
    private int shotsOnTarget;

    public Statistic() {
    }

    public Statistic(int goals, int assists, int yellowCards, int redCards, int tackles, int shotsOnTarget) {
        this.goals = goals;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.tackles = tackles;
        this.shotsOnTarget = shotsOnTarget;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getTackles() {
        return tackles;
    }

    public void setTackles(int tackles) {
        this.tackles = tackles;
    }

    public int getShotsOnTarget() {
        return shotsOnTarget;
    }

    public void setShotsOnTarget(int shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }
}
