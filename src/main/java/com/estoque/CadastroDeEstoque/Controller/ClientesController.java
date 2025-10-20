package com.estoque.CadastroDeEstoque.Controller;

import com.estoque.CadastroDeEstoque.DTO.ClientesDTO;
import com.estoque.CadastroDeEstoque.DTO.ProdutosDTO;
import com.estoque.CadastroDeEstoque.Service.ClientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    private ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @PostMapping
    public ResponseEntity<String> criarProduto(@RequestBody ClientesDTO cliente){
        ClientesDTO novoCliente = clientesService.criarCliente(cliente);
        return ResponseEntity.ok("Cliente criado com sucesso: Nome: " + novoCliente.getNome() + " ID: " + novoCliente.getId());
    }

    @GetMapping
    public ResponseEntity<List<ClientesDTO>> listarClientes(){
        List<ClientesDTO> clientesDTO = clientesService.listarClientes();
        return ResponseEntity.ok(clientesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> listarClientesPorId(@PathVariable Long id){
        ClientesDTO clientesId = clientesService.listarClientesPorId(id);
        if (clientesId != null){
            return ResponseEntity.ok("Cliente Encontrado: " + clientesId.getNome());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com ID: " + id + " não encontrado, Tente Novamente!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterarClientesPorId(@PathVariable Long id, @RequestBody ClientesDTO clienteAtualizado){
        ClientesDTO listarClientes = clientesService.listarClientesPorId(id);
        if(listarClientes != null){
            clientesService.atualizarCliente(id,clienteAtualizado);
            return ResponseEntity.ok("Cliente com ID: " + id + " atualizado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente não encontrado em nossa base de dados, Tente Novamente!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProdutosPorId(@PathVariable Long id) {
        ClientesDTO listar = clientesService.listarClientesPorId(id);
        if (listar != null){
            clientesService.deletarClientePorId(id);
            return ResponseEntity.ok("Cliente com ID: " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente não encontrado em nossa base de dados, Tente Novamente!");
        }

    }
}
