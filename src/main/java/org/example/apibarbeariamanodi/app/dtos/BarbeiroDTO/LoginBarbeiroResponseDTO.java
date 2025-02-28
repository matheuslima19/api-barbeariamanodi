package org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO;

public record LoginBarbeiroResponseDTO(
        Integer id,
        String nome,
        String email,
        String token
) {
}
