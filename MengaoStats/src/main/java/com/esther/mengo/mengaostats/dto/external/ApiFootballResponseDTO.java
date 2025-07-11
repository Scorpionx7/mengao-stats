package com.esther.mengo.mengaostats.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiFootballResponseDTO(
        List<TeamResponseDTO> response
) {
}
