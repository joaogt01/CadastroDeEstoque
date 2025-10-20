package com.estoque.CadastroDeEstoque.Controller;

import com.estoque.CadastroDeEstoque.DTO.ProdutosDTO;
import com.estoque.CadastroDeEstoque.Service.ProdutosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping
    @Operation(summary = "Cria um novo produto", description = "Essa rota traz a função de criar um produto e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do Produto")
    })
    public ResponseEntity<String> criarProduto(@RequestBody ProdutosDTO produtos){
        ProdutosDTO novoProduto = produtosService.criarProduto(produtos);
        return ResponseEntity.ok("Produto criado com sucesso: Nome: " + novoProduto.getNome() + " ID: " + novoProduto.getId());
    }

    @GetMapping
    public ResponseEntity<List<ProdutosDTO>> listarProdutos(){
        List<ProdutosDTO> produtosDTO = produtosService.listarProdutos();
        return ResponseEntity.ok(produtosDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista o produto por ID", description = "Essa rota lista um produto por seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Produto nao encontrado")
    })
    public ResponseEntity<String> listarProdutosPorId(@PathVariable Long id){
        ProdutosDTO produtosId = produtosService.listarProdutosPorId(id);
        if ( produtosId != null){
            return ResponseEntity.ok("Produto encontrado: " + produtosId.getNome());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado em nossa base de dados, Tente Novamente!");
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Altera produto por ID", description = "Essa rota traz a função de alterar um produto por seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Produto não encontrado, não foi possivel alterar")
    })
    public ResponseEntity<String> alterarProdutosPorId(
            @Parameter(description = "Usuario manda o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do Produto a ser atualizado no corpo da requisição")
            @RequestBody ProdutosDTO produtosAtualizado){
        ProdutosDTO listar = produtosService.listarProdutosPorId(id);
        if(listar != null){
            produtosService.atualizarProduto(id,produtosAtualizado);
            return ResponseEntity.ok("Produto com id " + id + "atualizado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não encontrado em nossa base de dados, Tente Novamente!");
        }

    }

    @DeleteMapping("/{id}")
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
