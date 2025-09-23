package com.estoque.CadastroDeEstoque.Produtos;

import org.springframework.stereotype.Component;

@Component
public class ProdutosMapper {

    public ProdutosModel map(ProdutosDTO produtosDTO){
        ProdutosModel produtosModel = new ProdutosModel();
        produtosModel.setId(produtosDTO.getId());
        produtosModel.setNome(produtosDTO.getNome());
        produtosModel.setPreco(produtosDTO.getPreco());
        produtosModel.setQuantidade(produtosDTO.getQuantidade());
        return produtosModel;
    }

    public ProdutosDTO map(ProdutosModel produtosModel){
        ProdutosDTO produtosDTO = new ProdutosDTO();
        produtosDTO.setId(produtosModel.getId());
        produtosDTO.setNome(produtosModel.getNome());
        produtosDTO.setPreco(produtosModel.getPreco());
        produtosDTO.setQuantidade(produtosModel.getQuantidade());
        return produtosDTO;
    }

}
