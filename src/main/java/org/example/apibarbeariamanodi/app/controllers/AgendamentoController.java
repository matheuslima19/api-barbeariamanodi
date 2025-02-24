package org.example.apibarbeariamanodi.app.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamentos")
@SecurityRequirement(name = "bearerAuth")
public class AgendamentoController {
}
