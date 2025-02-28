package org.example.apibarbeariamanodi.app.services;

import jakarta.validation.Valid;
import org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO.BarbeiroDTO;
import org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO.CreateBarbeiroDTO;
import org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO.LoginBarbeiroRequest;
import org.example.apibarbeariamanodi.app.dtos.BarbeiroDTO.LoginBarbeiroResponseDTO;
import org.example.apibarbeariamanodi.app.mappers.BarbeiroMapper;
import org.example.apibarbeariamanodi.domain.entities.Barbeiro;
import org.example.apibarbeariamanodi.domain.repositories.IBarbeiroRepository;
import org.example.apibarbeariamanodi.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BarbeiroService {

    @Autowired
    private IBarbeiroRepository barbeiroRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public BarbeiroDTO register(CreateBarbeiroDTO createBarbeiroDTO) {
        Optional<Barbeiro> existingBarbeiro = barbeiroRepository.findByEmail(createBarbeiroDTO.getEmail());
        if (existingBarbeiro.isPresent()) {
            throw new RuntimeException("Barbeiro já existe com esse e-mail");
        }
        Barbeiro barbeiro = BarbeiroMapper.toEntity(createBarbeiroDTO);
        barbeiro.setSenha(createBarbeiroDTO.getSenha());

        Barbeiro savedBarbeiro = barbeiroRepository.save(barbeiro);
        return BarbeiroMapper.toDTO(savedBarbeiro);
    }

    public LoginBarbeiroResponseDTO login(@Valid LoginBarbeiroRequest loginBarbeiroRequest){
        Optional<Barbeiro> barbeiro = barbeiroRepository.findByEmail(loginBarbeiroRequest.email());

        if (!new BCryptPasswordEncoder().matches(loginBarbeiroRequest.senha(), barbeiro.get().getSenha())) {
            throw new RuntimeException("Sua conta ou senha está incorreta.");
        }

        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginBarbeiroRequest.email(), loginBarbeiroRequest.senha());
        var auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = tokenService.generateTokenBarbeiro(barbeiro.get());
        return new LoginBarbeiroResponseDTO(barbeiro.get().getId(), barbeiro.get().getNome(), barbeiro.get().getEmail(), token);
    }
}
