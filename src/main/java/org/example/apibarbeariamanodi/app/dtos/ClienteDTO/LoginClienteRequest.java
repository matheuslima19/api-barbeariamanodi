package org.example.apibarbeariamanodi.app.dtos.ClienteDTO;

import jakarta.validation.constraints.NotBlank;

public record LoginClienteRequest(
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
