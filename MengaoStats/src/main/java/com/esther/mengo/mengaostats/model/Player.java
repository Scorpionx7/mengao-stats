package com.esther.mengo.mengaostats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    @NotNull(message = "Name is required")
    private String name;

    @Size(min = 1, max = 50, message = "Position must be between 1 and 50 characters")
    @NotNull(message = "Position is required")
    private String position;

    @Min(value = 16, message = "Age must be at least 16")
    @NotNull(message = "Age is required")
    private int age;

    @Min(value = 1, message = "Number must be at least 1")
    @NotNull(message = "Number is required")
    private int number;

    private int goals;
    private int assists;

    @ManyToOne
    private Statistic statistic;

    public Player() {
    }

    public Player(String name, String position, int age, int number, int goals, int assists, Statistic statistic) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.number = number;
        this.goals = goals;
        this.assists = assists;
        this.statistic = statistic;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
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
}
