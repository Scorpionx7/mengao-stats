package com.esther.mengo.mengaostats.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VenueDTO(
        String name,
        String city
) {
}
