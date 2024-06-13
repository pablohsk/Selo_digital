package com.tjsc.selodigital.utils;

import com.tjsc.selodigital.dto.EnteDeclaradoDTO;
import com.tjsc.selodigital.model.EnteDeclarado;

public class Mapper {
    public static EnteDeclaradoDTO toDTO(EnteDeclarado enteDeclarado) {
        EnteDeclaradoDTO dto = new EnteDeclaradoDTO();
        dto.setId(enteDeclarado.getId());
        dto.setNome(enteDeclarado.getNome());
        dto.setDescricao(enteDeclarado.getDescricao());
        return dto;
    }

    public static EnteDeclarado toEntity(EnteDeclaradoDTO dto) {
        EnteDeclarado enteDeclarado = new EnteDeclarado();
        enteDeclarado.setId(dto.getId());
        enteDeclarado.setNome(dto.getNome());
        enteDeclarado.setDescricao(dto.getDescricao());
        return enteDeclarado;
    }
}
