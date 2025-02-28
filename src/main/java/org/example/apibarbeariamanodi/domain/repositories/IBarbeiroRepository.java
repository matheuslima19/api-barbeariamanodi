package org.example.apibarbeariamanodi.domain.repositories;

import org.example.apibarbeariamanodi.domain.entities.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBarbeiroRepository extends JpaRepository<Barbeiro, Integer> {
    Optional<Barbeiro> findByEmail(String email);
}
