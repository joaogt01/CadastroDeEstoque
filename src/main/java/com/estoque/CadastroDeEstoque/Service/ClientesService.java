package com.estoque.CadastroDeEstoque.Service;

import com.estoque.CadastroDeEstoque.DTO.ClientesDTO;
import com.estoque.CadastroDeEstoque.Mapper.ClientesMapper;
import com.estoque.CadastroDeEstoque.Model.Clientes;
import com.estoque.CadastroDeEstoque.Repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientesService {
    private ClientesRepository clientesRepository;
    private ClientesMapper clientesMapper;

    public ClientesService(ClientesRepository clientesRepository, ClientesMapper clientesMapper) {
        this.clientesRepository = clientesRepository;
        this.clientesMapper = clientesMapper;
    }

    public List<ClientesDTO> listarClientes(){
        List<Clientes> clientes = clientesRepository.findAll();
        return clientes.stream()
                .map(clientesMapper::map)
                .collect(Collectors.toList());
    }

    public ClientesDTO listarClientesPorId(Long id){
        Optional<Clientes> clientesPorId = clientesRepository.findById(id);
        return clientesPorId.map(clientesMapper::map).orElse(null);
    }

    public ClientesDTO criarCliente(ClientesDTO clientesDTO){
        Clientes clientes = clientesMapper.map(clientesDTO);
        clientes = clientesRepository.save(clientes);
        return clientesMapper.map(clientes);
    }

    public void deletarClientePorId(Long id){
        clientesRepository.deleteById(id);
    }

    public ClientesDTO atualizarCliente(Long id, ClientesDTO clientesDTO){
        Optional<Clientes> clienteExistente = clientesRepository.findById(id);
        if (clienteExistente.isPresent()){
            Clientes clienteAtualizado = clientesMapper.map(clientesDTO);
            clienteAtualizado.setId(id);
            Clientes clienteSalvo = clientesRepository.save(clienteAtualizado);
            return clientesMapper.map(clienteSalvo);
        }
        return null;
    }
}
