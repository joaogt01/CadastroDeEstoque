package com.estoque.CadastroDeEstoque.Produtos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private ProdutosService produtosService;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarProduto(@RequestBody ProdutosDTO produtos){
        ProdutosDTO novoProduto = produtosService.criarProduto(produtos);
        return ResponseEntity.ok("Produto criado com sucesso: Nome: " + novoProduto.getNome() + " ID: " + novoProduto.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutosDTO>> listarProdutos(){
        List<ProdutosDTO> produtosDTO = produtosService.listarProdutos();
        return ResponseEntity.ok(produtosDTO);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<String> listarProdutosPorId(@PathVariable Long id){
        ProdutosDTO produtosId = produtosService.listarProdutosPorId(id);
        if ( produtosId != null){
            return ResponseEntity.ok("Produto encontrado: " + produtosId.getNome());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado em nossa base de dados, Tente Novamente!");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarProdutosPorId(@PathVariable Long id, @RequestBody ProdutosDTO produtosAtualizado){
        ProdutosDTO listar = produtosService.listarProdutosPorId(id);
        if(listar != null){
            produtosService.atualizarProduto(id,produtosAtualizado);
            return ResponseEntity.ok("Produto com id " + id + "atualizado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado em nossa base de dados, Tente Novamente!");
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProdutosPorId(@PathVariable Long id) {
        ProdutosDTO listar = produtosService.listarProdutosPorId(id);
        if (listar != null){
            produtosService.deletarProdutoPorId(id);
            return ResponseEntity.ok("Produto com ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado em nossa base de dados, Tente Novamente!");
        }

    }
}
