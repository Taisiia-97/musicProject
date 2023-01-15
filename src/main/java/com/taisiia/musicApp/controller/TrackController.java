package com.taisiia.musicApp.controller;

import com.taisiia.musicApp.domain.dto.TrackDto;
import com.taisiia.musicApp.mapper.TrackMapper;
import com.taisiia.musicApp.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tracks")
public class TrackController {

    private final TrackMapper trackMapper;
    private final TrackService trackService;

    @GetMapping
    public List<TrackDto> getTracks() {
        return trackMapper.toListDto(trackService.getAllTracks());
    }


    @GetMapping("/{id}")
    public TrackDto findTrackById(@PathVariable Long id) {

        return trackMapper.toDto(trackService.findTrackById(id));
    }

}
