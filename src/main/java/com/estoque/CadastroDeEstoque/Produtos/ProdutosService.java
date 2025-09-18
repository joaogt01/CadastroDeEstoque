package com.estoque.CadastroDeEstoque.Produtos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    private ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    //Listar todos os produtos
    public List<ProdutosModel> listarProdutos(){
        return produtosRepository.findAll();
    }

    //Listar produtos por ID
    public ProdutosModel listarProdutosPorId(Long id){
        Optional<ProdutosModel> produtosPorId = produtosRepository.findById(id);
        return produtosPorId.orElse(null);
    }

    //Criar novo produto
    public ProdutosModel criarProduto(ProdutosModel produto){
        return produtosRepository.save(produto);
    }
}
