package com.taisiia.musicApp.controller;

import com.taisiia.musicApp.domain.dto.EditionDto;
import com.taisiia.musicApp.mapper.EditionMapper;
import com.taisiia.musicApp.service.EditionService;
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
    private final EditionMapper editionMapper;
    private final EditionService editionService;

    @GetMapping("/{id}")
    public EditionDto findEditionById(@PathVariable Long id) {
        return editionMapper.toDto(editionService.findById(id));
    }

    @GetMapping
    public List<EditionDto> getEditions() {
        return editionMapper.toListDto(editionService.getAllEditions());
    }

}
