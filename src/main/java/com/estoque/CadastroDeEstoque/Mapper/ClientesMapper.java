package com.estoque.CadastroDeEstoque.Mapper;

import com.estoque.CadastroDeEstoque.DTO.ClientesDTO;
import com.estoque.CadastroDeEstoque.Model.Clientes;
import org.springframework.stereotype.Component;

@Component
public class ClientesMapper {

    public Clientes map(ClientesDTO clientesDTO){
        if (clientesDTO == null) return null;
        Clientes clientes = new Clientes();
        clientes.setId(clientesDTO.getId());
        clientes.setNome(clientesDTO.getNome());
        clientes.setEmail(clientesDTO.getEmail());
        clientes.setTelefone(clientesDTO.getTelefone());
        return clientes;
    }

    public ClientesDTO map(Clientes clientes){
        if (clientes == null) return null;
        ClientesDTO clientesDTO = new ClientesDTO();
        clientesDTO.setId(clientes.getId());
        clientesDTO.setNome(clientes.getNome());
        clientesDTO.setEmail(clientes.getEmail());
        clientesDTO.setTelefone(clientes.getTelefone());
        return clientesDTO;
    }
}
