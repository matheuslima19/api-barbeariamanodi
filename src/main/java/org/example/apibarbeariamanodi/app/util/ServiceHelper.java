package org.example.apibarbeariamanodi.app.util;

import org.example.apibarbeariamanodi.app.exception.RecursoNaoEncontradoException;
import org.example.apibarbeariamanodi.domain.entities.Barbeiro;
import org.example.apibarbeariamanodi.domain.entities.Cliente;
import org.example.apibarbeariamanodi.domain.repositories.IBarbeiroRepository;
import org.example.apibarbeariamanodi.domain.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceHelper {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IBarbeiroRepository barbeiroRepository;

    public Cliente getValidCliente(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            throw new RecursoNaoEncontradoException("Cliente não encontrado");
        }
        return cliente;
    }

    public Barbeiro getValidBarbeiro(int id) {
        return barbeiroRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Barbeiro não encontrado com o id: " + id));
    }
}
