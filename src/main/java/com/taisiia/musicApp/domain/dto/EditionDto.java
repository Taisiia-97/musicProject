package com.taisiia.musicApp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditionDto {
    private Long id;
    private String name;

    private Set<TrackDto> tracks;

    private Double totalDuration;
}
