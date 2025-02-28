package org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO;

import jakarta.validation.constraints.NotBlank;

public record LoginBarbeiroRequest(
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
