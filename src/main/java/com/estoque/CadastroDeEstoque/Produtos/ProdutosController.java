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

    @PutMapping("/alterarID")
    public String alterarProdutosPorId(){
        return "Alterar produtos por id";
    }

    @DeleteMapping("/deletarID")
    public String deletarProdutosPorId(){
        return "Deletar Produtos Por Id";
    }
}
