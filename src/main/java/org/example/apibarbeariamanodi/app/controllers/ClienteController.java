package org.example.apibarbeariamanodi.app.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.example.apibarbeariamanodi.app.dtos.ClienteDTO.*;
import org.example.apibarbeariamanodi.app.services.ClienteService;
import org.example.apibarbeariamanodi.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@SecurityRequirement(name = "bearerAuth")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/registrar")
    public ResponseEntity<ClienteDTO> registerCliente(@RequestBody CreateClienteDTO createClienteDTO) {
        ClienteDTO clienteDTO = clienteService.register(createClienteDTO);
        return new ResponseEntity<>(clienteDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")@PermitAll
    public ResponseEntity<LoginClienteResponseDTO> login(@RequestBody @Valid LoginClienteRequest loginDTO) {
        LoginClienteResponseDTO loginClienteResponseDTO = clienteService.login(loginDTO);
        return ResponseEntity.ok(loginClienteResponseDTO);
    }
}
