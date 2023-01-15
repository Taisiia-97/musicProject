package com.taisiia.musicApp.controller;

import com.taisiia.musicApp.domain.dao.Edition;
import com.taisiia.musicApp.repository.EditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/editions")
public class EditionController {
    private final EditionRepository editionRepository;

    @GetMapping("/{id}")
    public Edition findEditionById(@PathVariable Long id) {
        return editionRepository.findById(id).orElseThrow(()->new RuntimeException("Not found entity"));
    }

    @GetMapping
    public List<Edition> getEditions() {
        return editionRepository.findAll();
    }

}
