package com.taisiia.musicApp.controller;

import com.taisiia.musicApp.domain.dao.Album;
import com.taisiia.musicApp.domain.dao.Track;
import com.taisiia.musicApp.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;
    @GetMapping("/{id}")
    public Album getAlbumByEdition(@PathVariable Long id){
        return albumService.findByEdition(id);
    }
    @GetMapping("/edition/tracks/{id}")
    public Set<Track> getTracksByEdition(@PathVariable Long id){
        return albumService.getTracksByEdition(id);
    }
}
