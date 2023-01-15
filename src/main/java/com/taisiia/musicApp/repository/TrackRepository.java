package com.taisiia.musicApp.repository;

import com.taisiia.musicApp.domain.dao.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track,Long> {
}
