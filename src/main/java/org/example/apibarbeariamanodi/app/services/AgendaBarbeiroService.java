package org.example.apibarbeariamanodi.app.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.apibarbeariamanodi.app.dtos.AgendaBarbeiroDTO;
import org.example.apibarbeariamanodi.app.mappers.AgendaBarbeiroMapper;
import org.example.apibarbeariamanodi.domain.entities.AgendaBarbeiro;
import org.example.apibarbeariamanodi.domain.repositories.IAgendaBarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AgendaBarbeiroService {

    @Autowired
    private IAgendaBarbeiroRepository repository;

    @Autowired
    private AgendaBarbeiroMapper mapper;

    public List<AgendaBarbeiroDTO> listarAgendas() {
        List<AgendaBarbeiro> agendas = repository.findAll();
        return mapper.toDTOList(agendas);
    }

    public AgendaBarbeiroDTO salvarAgenda(AgendaBarbeiroDTO dto) {
        AgendaBarbeiro entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }
}
