package org.example.apibarbeariamanodi.app.services;

import jakarta.validation.Valid;
import org.example.apibarbeariamanodi.app.dtos.ClienteDTO.*;
import org.example.apibarbeariamanodi.app.mappers.ClienteMapper;
import org.example.apibarbeariamanodi.domain.entities.Cliente;
import org.example.apibarbeariamanodi.domain.repositories.IClienteRepository;
import org.example.apibarbeariamanodi.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ClienteDTO register(CreateClienteDTO createClienteDTO) {
        Optional<Cliente> existingClient = clienteRepository.findByEmail(createClienteDTO.getEmail());
        if (existingClient.isPresent()) {
            throw new RuntimeException("Cliente já existe com esse e-mail");
        }
        Cliente cliente = ClienteMapper.toEntity(createClienteDTO);
        cliente.setSenha(createClienteDTO.getSenha());

        Cliente savedCliente = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(savedCliente);
    }

    public LoginClienteResponseDTO login(@Valid LoginClienteRequest loginClienteRequest){
        Optional<Cliente> cliente = clienteRepository.findByEmail(loginClienteRequest.email());

        if (!new BCryptPasswordEncoder().matches(loginClienteRequest.senha(), cliente.get().getSenha())) {
            throw new RuntimeException("Sua conta ou senha está incorreta.");
        }

        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginClienteRequest.email(), loginClienteRequest.senha());
        var auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = tokenService.generateTokenCliente(cliente.get());
        return new LoginClienteResponseDTO(cliente.get().getId(), cliente.get().getNome(), cliente.get().getEmail(), token);
    }
}
