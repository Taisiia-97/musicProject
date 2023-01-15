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

   public Track findTrackById(Long id) {

        return trackRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Track"));
    }

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
}
