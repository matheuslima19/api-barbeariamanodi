package org.example.apibarbeariamanodi.domain.repositories;

import org.example.apibarbeariamanodi.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByEmail(String email);
}
