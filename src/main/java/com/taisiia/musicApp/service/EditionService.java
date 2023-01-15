package com.taisiia.musicApp.service;

import com.taisiia.musicApp.repository.EditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditionService {
    private final EditionRepository editionRepository;
}
