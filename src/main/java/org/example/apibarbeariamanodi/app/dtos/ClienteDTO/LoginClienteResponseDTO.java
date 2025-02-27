package org.example.apibarbeariamanodi.app.dtos.ClienteDTO;

public record LoginClienteResponseDTO(
        Integer id,
        String nome,
        String email,
        String token
) {
}
