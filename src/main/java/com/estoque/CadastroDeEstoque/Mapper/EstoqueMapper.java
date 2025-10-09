package com.estoque.CadastroDeEstoque.Mapper;

import com.estoque.CadastroDeEstoque.DTO.EstoqueDTO;
import com.estoque.CadastroDeEstoque.Model.Estoque;
import org.springframework.stereotype.Component;

@Component
public class EstoqueMapper {

    public Estoque map(EstoqueDTO estoqueDTO){
        Estoque estoque = new Estoque();
        estoque.setId(estoqueDTO.getId());
        estoque.setLocalizacao(estoqueDTO.getLocalizacao());
        return estoque;
    }

    public EstoqueDTO map(Estoque estoque){
        EstoqueDTO estoqueDTO = new EstoqueDTO();
        estoqueDTO.setId(estoque.getId());
        estoqueDTO.setLocalizacao(estoque.getLocalizacao());
        return estoqueDTO;
    }
}
