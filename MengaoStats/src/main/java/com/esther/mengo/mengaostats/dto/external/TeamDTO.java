package com.esther.mengo.mengaostats.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TeamDTO(
        int id,
        String name,
        String country,
        String logo
) {
}
