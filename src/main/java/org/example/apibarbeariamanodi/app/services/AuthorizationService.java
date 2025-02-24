package org.example.apibarbeariamanodi.app.services;

import org.example.apibarbeariamanodi.domain.entities.Barbeiro;
import org.example.apibarbeariamanodi.domain.entities.Cliente;
import org.example.apibarbeariamanodi.domain.repositories.IBarbeiroRepository;
import org.example.apibarbeariamanodi.domain.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private IClienteRepository clienteRepository;
    @Autowired
    private IBarbeiroRepository barbeiroRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(username);
        if (cliente != null) {
            return cliente;
        }
        Barbeiro barbeiro = barbeiroRepository.findByEmail(username);
        if (barbeiro != null) {
            return barbeiro;
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}
