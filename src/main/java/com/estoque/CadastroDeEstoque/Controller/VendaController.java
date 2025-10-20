package com.estoque.CadastroDeEstoque.Controller;

import com.estoque.CadastroDeEstoque.DTO.ClientesDTO;
import com.estoque.CadastroDeEstoque.DTO.VendaDTO;
import com.estoque.CadastroDeEstoque.Service.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    private VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<String> criarVenda(@RequestBody VendaDTO venda){
        VendaDTO novaVenda = vendaService.criarVenda(venda);
        return ResponseEntity.ok("Venda criada com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<VendaDTO>> listarVendas(){
        List<VendaDTO> vendas = vendaService.listarVendas();
        return ResponseEntity.ok(vendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> listarVendaPorId(@PathVariable Long id){
        VendaDTO vendaId = vendaService.listarVendaPorId(id);
        if (vendaId != null){
            return ResponseEntity.ok("Venda Encontrada: " + vendaId.getTotal());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Venda com ID: " + id + " não encontrada, Tente Novamente!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterarVendaPorId(@PathVariable Long id, @RequestBody VendaDTO vendaAtualizada){
        VendaDTO listarVendasID = vendaService.listarVendaPorId(id);
        if(listarVendasID != null){
            vendaService.atualizarVenda(id,vendaAtualizada);
            return ResponseEntity.ok("Venda com ID: " + id + " atualizada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Venda não encontrada em nossa base de dados, Tente Novamente!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarVendaPorId(@PathVariable Long id) {
        VendaDTO listar = vendaService.listarVendaPorId(id);
        if (listar != null){
            vendaService.deletarVendaPorId(id);
            return ResponseEntity.ok("Venda com ID: " + id + " deletada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("venda não encontrada em nossa base de dados, Tente Novamente!");
        }

    }

}
