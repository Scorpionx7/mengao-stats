package com.esther.mengo.mengaostats.model;

public class Player {

    private Long id;
    private String name;
    private String position;
    private int age;
    private int number;
    private Statistic statistic;

    public Player() {
    }

    public Player(String name, String position, int age, int number) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.number = number;
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
}
