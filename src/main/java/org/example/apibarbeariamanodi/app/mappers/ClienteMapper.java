package org.example.apibarbeariamanodi.app.mappers;


import org.example.apibarbeariamanodi.app.dtos.ClienteDTO.ClienteDTO;
import org.example.apibarbeariamanodi.app.dtos.ClienteDTO.CreateClienteDTO;
import org.example.apibarbeariamanodi.domain.entities.Cliente;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());
        dto.setRole(cliente.getRole());
        return dto;
    }

    public static Cliente toEntity(CreateClienteDTO dto) {
        if (dto == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        cliente.setRole(dto.getRole());
        return cliente;
    }
}
