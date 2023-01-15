package com.taisiia.musicApp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private Long id;

    private String albumPerformer;
    private String albumTittle;
    private LocalDate releaseDate;

    private Set<EditionDto> editions;
}
