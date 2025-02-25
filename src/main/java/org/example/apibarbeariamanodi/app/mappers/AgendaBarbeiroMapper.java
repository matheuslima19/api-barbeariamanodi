package org.example.apibarbeariamanodi.app.mappers;

import org.example.apibarbeariamanodi.app.dtos.AgendaBarbeiroDTO;
import org.example.apibarbeariamanodi.domain.entities.AgendaBarbeiro;
import org.example.apibarbeariamanodi.domain.enums.DiaSemana;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgendaBarbeiroMapper {

    public static AgendaBarbeiroDTO toDTO(AgendaBarbeiro agenda) {
        if (agenda == null) {
            return null;
        }

        AgendaBarbeiroDTO dto = new AgendaBarbeiroDTO();
        dto.setId(agenda.getId());
        dto.setIdBarbeiro(agenda.getBarbeiro().getId());
        dto.setDiaSemana(agenda.getDiaSemana().name());
        dto.setHorarioInicio(agenda.getHoraInicio().toString());
        dto.setHorarioFim(agenda.getHoraFim().toString());
        dto.setAtivo(agenda.getAtivo());

        return dto;
    }

    public static AgendaBarbeiro toEntity(AgendaBarbeiroDTO dto) {
        if (dto == null) {
            return null;
        }

        AgendaBarbeiro agenda = new AgendaBarbeiro();
        agenda.setId(dto.getId());
        agenda.setDiaSemana(DiaSemana.valueOf(dto.getDiaSemana()));
        agenda.setHoraInicio(LocalTime.parse(dto.getHorarioInicio()));
        agenda.setHoraFim(LocalTime.parse(dto.getHorarioFim()));
        agenda.setAtivo(dto.getAtivo());

        return agenda;
    }

    public static List<AgendaBarbeiroDTO> toDTOList(List<AgendaBarbeiro> entities) {
        return entities.stream().map(AgendaBarbeiroMapper::toDTO).collect(Collectors.toList());
    }

    public static List<AgendaBarbeiro> toEntityList(List<AgendaBarbeiroDTO> dtos) {
        return dtos.stream().map(AgendaBarbeiroMapper::toEntity).collect(Collectors.toList());
    }
}
