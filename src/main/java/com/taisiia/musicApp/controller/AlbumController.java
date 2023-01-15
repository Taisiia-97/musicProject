package com.taisiia.musicApp.controller;

import com.taisiia.musicApp.domain.dto.AlbumDto;
import com.taisiia.musicApp.domain.dto.TrackDto;
import com.taisiia.musicApp.mapper.AlbumMapper;
import com.taisiia.musicApp.mapper.TrackMapper;
import com.taisiia.musicApp.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final TrackMapper trackMapper;
    private final AlbumMapper albumMapper;

    @GetMapping
    private List<AlbumDto> getAllAlbums() {

        return albumMapper.toListDto(albumService.getAllAlbums());
    }

    @GetMapping("/{id}")
    public AlbumDto getAlbumByEditionId(@PathVariable Long id) {
        return albumMapper.toDto(albumService.findByEdition(id));
    }

    @GetMapping("/edition/tracks/{id}")
    public List<TrackDto> getTracksByEdition(@PathVariable Long id) {
        return trackMapper.toListDto(albumService.getTracksByEdition(id));
    }
}
