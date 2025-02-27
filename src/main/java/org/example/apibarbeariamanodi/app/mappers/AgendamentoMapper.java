package org.example.apibarbeariamanodi.app.mappers;

import org.example.apibarbeariamanodi.app.dtos.AgendamentoDTO.AgendamentoDTO;
import org.example.apibarbeariamanodi.domain.entities.Agendamento;

public class AgendamentoMapper {

    public static AgendamentoDTO toDTO(Agendamento agendamento) {
        if (agendamento == null) {
            return null;
        }
        AgendamentoDTO dto = new AgendamentoDTO();
        dto.setId(agendamento.getId());
        dto.setDataAgendamento(agendamento.getDataAgendamento());
        dto.setHorario(agendamento.getHorario());
        dto.setStatus(agendamento.getStatus());
        dto.setNomeCliente(agendamento.getCliente() != null ? agendamento.getCliente().getNome() : null);
        dto.setNomeBarbeiro(agendamento.getBarbeiro() != null ? agendamento.getBarbeiro().getNome() : null);
        return dto;
    }

    public static Agendamento toEntity(AgendamentoDTO dto) {
        if (dto == null) {
            return null;
        }
        Agendamento agendamento = new Agendamento();
        agendamento.setId(dto.getId());
        agendamento.setDataAgendamento(dto.getDataAgendamento());
        agendamento.setHorario(dto.getHorario());
        agendamento.setStatus(dto.getStatus());
        return agendamento;
    }
}