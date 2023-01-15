package com.taisiia.musicApp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDto {
    private Long id;
    private String tittle;
    private String performer;
    private LocalTime duration;
}
