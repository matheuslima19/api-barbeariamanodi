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

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final IClienteRepository clienteRepository;
    private final IBarbeiroRepository barbeiroRepository;

    @Autowired
    public CustomUserDetailsService(IClienteRepository clienteRepository, IBarbeiroRepository barbeiroRepository) {
        this.clienteRepository = clienteRepository;
        this.barbeiroRepository = barbeiroRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        if (cliente.isPresent()) {
            return cliente.get(); // Cliente já implementa UserDetails
        }


        Optional<Barbeiro> barbeiro = barbeiroRepository.findByEmail(email);
        if (barbeiro.isPresent()) {
            return barbeiro.get();
        }

        throw new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email);
    }
}
