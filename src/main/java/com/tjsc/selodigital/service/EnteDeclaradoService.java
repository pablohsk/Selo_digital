package com.tjsc.selodigital.service;

import com.tjsc.selodigital.model.EnteDeclarado;
import com.tjsc.selodigital.repository.EnteDeclaradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnteDeclaradoService {

    @Autowired
    private EnteDeclaradoRepository enteDeclaradoRepository;

    public List<EnteDeclarado> getAllEntes() {
        return enteDeclaradoRepository.findAll();
    }

    public EnteDeclarado createEnte(EnteDeclarado enteDeclarado) {
        return enteDeclaradoRepository.save(enteDeclarado);
    }
}
