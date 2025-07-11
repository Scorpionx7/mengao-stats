package com.esther.mengo.mengaostats.dto;

public record PlayerDTO(Long id,
                        String name,
                        String position,
                        int age,
                        int number,
                        int goals,
                        int assists) {
}
