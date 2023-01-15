package com.taisiia.musicApp.controller;

import com.taisiia.musicApp.domain.dao.Track;
import com.taisiia.musicApp.repository.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tracks")
public class TrackController {

    private final TrackRepository trackRepository;

    @GetMapping
    public List<Track> getTracks() {
        return trackRepository.findAll();
    }
}
