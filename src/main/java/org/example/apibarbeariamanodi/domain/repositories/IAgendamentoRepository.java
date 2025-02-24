package org.example.apibarbeariamanodi.domain.repositories;

import org.example.apibarbeariamanodi.domain.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgendamentoRepository extends JpaRepository<Agendamento, Integer> {
}
