package com.taisiia.musicApp.repository;

import com.taisiia.musicApp.domain.dao.Album;
import com.taisiia.musicApp.domain.dao.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {
   Optional<Album> findAlbumByEditionsContains(Edition edition);

}
