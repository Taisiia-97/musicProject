package com.taisiia.musicApp.repository;

import com.taisiia.musicApp.domain.dao.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditionRepository extends JpaRepository<Edition,Long> {
}
