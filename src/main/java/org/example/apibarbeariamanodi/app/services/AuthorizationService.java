package org.example.apibarbeariamanodi.app.services;

import org.example.apibarbeariamanodi.domain.entities.Cliente;
import org.example.apibarbeariamanodi.domain.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AuthorizationService implements UserDetailsService {

    @Autowired
    IClienteRepository clienteRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findByEmail(username);
        return cliente.orElseThrow(() -> new UsernameNotFoundException("Dados inválidos"));
    }
}