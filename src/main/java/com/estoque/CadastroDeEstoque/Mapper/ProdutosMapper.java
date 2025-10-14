package com.estoque.CadastroDeEstoque.Mapper;

import com.estoque.CadastroDeEstoque.DTO.ProdutosDTO;
import com.estoque.CadastroDeEstoque.Model.Estoque;
import com.estoque.CadastroDeEstoque.Model.ProdutosModel;
import com.estoque.CadastroDeEstoque.Repository.EstoqueRepository;
import org.springframework.stereotype.Component;

@Component
public class ProdutosMapper {

    private final EstoqueRepository estoqueRepository;

    public ProdutosMapper(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }


    public ProdutosModel map(ProdutosDTO produtosDTO){
        ProdutosModel produtosModel = new ProdutosModel();
        produtosModel.setId(produtosDTO.getId());
        produtosModel.setNome(produtosDTO.getNome());
        produtosModel.setPreco(produtosDTO.getPreco());
        produtosModel.setQuantidade(produtosDTO.getQuantidade());
        if (produtosDTO.getEstoqueId() != null) {
            Estoque estoque = estoqueRepository.findById(produtosDTO.getEstoqueId())
                    .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
            produtosModel.setEstoque(estoque);
        }
        return produtosModel;
    }

    public ProdutosDTO map(ProdutosModel produtosModel){
        ProdutosDTO produtosDTO = new ProdutosDTO();
        produtosDTO.setId(produtosModel.getId());
        produtosDTO.setNome(produtosModel.getNome());
        produtosDTO.setPreco(produtosModel.getPreco());
        produtosDTO.setQuantidade(produtosModel.getQuantidade());
        if (produtosModel.getEstoque() != null) {
            produtosDTO.setEstoqueId(produtosModel.getEstoque().getId());
        }
        return produtosDTO;
    }

}
