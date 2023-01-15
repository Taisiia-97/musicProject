package com.taisiia.musicApp.service;

import com.taisiia.musicApp.domain.dao.Track;
import com.taisiia.musicApp.exception.NotFoundException;
import com.taisiia.musicApp.repository.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;

    Track findTrackById(Long id) {

        return trackRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Track"));
    }

    List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
}
