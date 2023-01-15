package com.taisiia.musicApp.service;

import com.taisiia.musicApp.domain.dao.Album;
import com.taisiia.musicApp.domain.dao.Track;
import com.taisiia.musicApp.exception.NotFoundException;
import com.taisiia.musicApp.repository.AlbumRepository;
import com.taisiia.musicApp.repository.EditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final EditionRepository editionRepository;

    public Album findByEdition(Long id) {
        var edition = editionRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found edition"));
        return albumRepository.findAlbumByEditionsContains(edition)
                .orElseThrow(() -> new NotFoundException("Not found album"));
    }


    public Set<Track> getTracksByEdition(Long id) {


        return editionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found edition"))
                .getTracks();
    }

    public List<Album> getAllAlbums() {

        return albumRepository.findAll();
    }
}
