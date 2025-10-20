package com.estoque.CadastroDeEstoque.Controller;

import com.estoque.CadastroDeEstoque.DTO.ClientesDTO;
import com.estoque.CadastroDeEstoque.DTO.EstoqueDTO;
import com.estoque.CadastroDeEstoque.Service.EstoqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    private EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping
    public ResponseEntity<String> criarEstoque(@RequestBody EstoqueDTO estoque){
        EstoqueDTO novoEstoque = estoqueService.criarNoEstoque(estoque);
        return ResponseEntity.ok("Estoque criado com sucesso: Local: " + novoEstoque.getLocalizacao() + " ID: " + novoEstoque.getId());
    }

    @GetMapping
    public ResponseEntity<List<EstoqueDTO>> listarEstoque(){
        List<EstoqueDTO> estoqueDTO = estoqueService.listarEstoque();
        return ResponseEntity.ok(estoqueDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> listarEstoquePorId(@PathVariable Long id){
        EstoqueDTO estoqueId = estoqueService.listarEstoquePorId(id);
        if (estoqueId != null){
            return ResponseEntity.ok("Estoque Encontrado: " + estoqueId.getLocalizacao());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Estoque com ID: " + id + " não encontrado, Tente Novamente!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterarEstoquePorId(@PathVariable Long id, @RequestBody EstoqueDTO estoqueAtualizado){
        EstoqueDTO listarClientes = estoqueService.listarEstoquePorId(id);
        if(listarClientes != null){
            estoqueService.atualizarEstoque(id,estoqueAtualizado);
            return ResponseEntity.ok("Estoque com ID: " + id + " atualizado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Estoque não encontrado em nossa base de dados, Tente Novamente!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEstoquePorId(@PathVariable Long id) {
        EstoqueDTO listar = estoqueService.listarEstoquePorId(id);
        if (listar != null){
            estoqueService.deletarEstoquePorId(id);
            return ResponseEntity.ok("Estoque com ID: " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Estoque não encontrado em nossa base de dados, Tente Novamente!");
        }

    }
}
