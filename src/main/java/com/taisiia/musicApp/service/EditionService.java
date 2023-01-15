package com.taisiia.musicApp.service;

import com.taisiia.musicApp.domain.dao.Edition;
import com.taisiia.musicApp.exception.NotFoundException;
import com.taisiia.musicApp.repository.EditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EditionService {
    private final EditionRepository editionRepository;

    public Edition findById(Long id) {

        return editionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found edition"));
    }

    public List<Edition> getAllEditions() {
        return editionRepository.findAll();
    }

}
