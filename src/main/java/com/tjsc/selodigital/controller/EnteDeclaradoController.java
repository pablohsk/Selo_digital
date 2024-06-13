package com.tjsc.selodigital.controller;

import com.tjsc.selodigital.dto.EnteDeclaradoDTO;
import com.tjsc.selodigital.model.EnteDeclarado;
import com.tjsc.selodigital.service.EnteDeclaradoService;
import com.tjsc.selodigital.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entes")
public class EnteDeclaradoController {

    @Autowired
    private EnteDeclaradoService enteDeclaradoService;

    @GetMapping
    public List<EnteDeclaradoDTO> getAllEntes() {
        return enteDeclaradoService.getAllEntes().stream()
                .map(Mapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public EnteDeclaradoDTO createEnte(@RequestBody EnteDeclaradoDTO enteDeclaradoDTO) {
        EnteDeclarado enteDeclarado = Mapper.toEntity(enteDeclaradoDTO);
        enteDeclarado = enteDeclaradoService.createEnte(enteDeclarado);
        return Mapper.toDTO(enteDeclarado);
    }
}
