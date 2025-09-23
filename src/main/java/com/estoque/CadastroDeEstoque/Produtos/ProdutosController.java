package com.estoque.CadastroDeEstoque.Produtos;

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
    public ProdutosModel criarProduto(@RequestBody ProdutosModel produtos){
        return produtosService.criarProduto(produtos);
    }

    @GetMapping("/listar")
    public List<ProdutosModel> listarProdutos(){
        return produtosService.listarProdutos();
    }

    @GetMapping("/listar/{id}")
    public ProdutosModel listarProdutosPorId(@PathVariable Long id){
        return produtosService.listarProdutosPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public ProdutosModel alterarProdutosPorId(@PathVariable Long id, @RequestBody ProdutosModel produtosAtualizado){
        return produtosService.atualizarProduto(id, produtosAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarProdutosPorId(@PathVariable Long id) {
        produtosService.deletarProdutoPorId(id);

    }
}
