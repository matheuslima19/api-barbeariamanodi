package org.example.apibarbeariamanodi.domain.repositories;

import org.example.apibarbeariamanodi.domain.entities.AgendaBarbeiro;
import org.example.apibarbeariamanodi.domain.enums.DiaSemana;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAgendaBarbeiroRepository extends JpaRepository<AgendaBarbeiro, Integer> {
    Optional<AgendaBarbeiro> findByDiaSemana(DiaSemana diaSemana);
    Optional<AgendaBarbeiro> findById (Integer id);
}
