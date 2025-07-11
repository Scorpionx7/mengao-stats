package com.esther.mengo.mengaostats.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FixtureDTO(int id,
                         ZonedDateTime date) {
}
