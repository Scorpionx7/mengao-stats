package com.esther.mengo.mengaostats.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.ZonedDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public record FixtureResponseDTO(FixtureDTO fixture,
                                 LeagueDTO league,
                                 TeamsDTO teams,
                                 GoalsDTO goals) {
}
