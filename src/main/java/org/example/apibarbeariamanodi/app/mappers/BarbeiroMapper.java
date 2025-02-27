package org.example.apibarbeariamanodi.app.mappers;

import org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO.BarbeiroDTO;
import org.example.apibarbeariamanodi.domain.entities.Barbeiro;

public class BarbeiroMapper {

    public static BarbeiroDTO toDTO(Barbeiro barbeiro) {
        if (barbeiro == null) {
            return null;
        }
        BarbeiroDTO dto = new BarbeiroDTO();
        dto.setId(barbeiro.getId());
        dto.setNome(barbeiro.getNome());
        dto.setEmail(barbeiro.getEmail());
        dto.setTelefone(barbeiro.getTelefone());
        dto.setRole(barbeiro.getRole());
        return dto;
    }

    public static Barbeiro toEntity(BarbeiroDTO dto) {
        if (dto == null) {
            return null;
        }
        Barbeiro barbeiro = new Barbeiro();
        barbeiro.setId(dto.getId());
        barbeiro.setNome(dto.getNome());
        barbeiro.setEmail(dto.getEmail());
        barbeiro.setTelefone(dto.getTelefone());
        barbeiro.setRole(dto.getRole());
        return barbeiro;
    }
}
