package org.example.apibarbeariamanodi.domain.repositories;

import org.example.apibarbeariamanodi.domain.entities.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBarbeiroRepository extends JpaRepository<Barbeiro, Integer> {
    Barbeiro findByEmail(String email);
}
