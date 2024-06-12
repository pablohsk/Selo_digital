package com.tjsc.selodigital.controller;

import com.tjsc.selodigital.model.EnteDeclarado;
import com.tjsc.selodigital.service.EnteDeclaradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entes")
public class EnteDeclaradoController {

    @Autowired
    private EnteDeclaradoService enteDeclaradoService;

    @GetMapping
    public List<EnteDeclarado> getAllEntes() {
        return enteDeclaradoService.getAllEntes();
    }

    @PostMapping
    public EnteDeclarado createEnte(@RequestBody EnteDeclarado enteDeclarado) {
        return enteDeclaradoService.createEnte(enteDeclarado);
    }
}
