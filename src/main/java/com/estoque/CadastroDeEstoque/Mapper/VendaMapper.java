package com.estoque.CadastroDeEstoque.Mapper;

import com.estoque.CadastroDeEstoque.DTO.VendaDTO;
import com.estoque.CadastroDeEstoque.Model.Venda;
import org.springframework.stereotype.Component;

@Component
public class VendaMapper {

    public Venda map(VendaDTO vendaDTO){
        Venda venda = new Venda();
        venda.setId(vendaDTO.getId());
        venda.setData(vendaDTO.getData());
        venda.setTotal(vendaDTO.getTotal());
        return venda;
    }

    public VendaDTO map(Venda venda){
        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setId(venda.getId());
        vendaDTO.setData(venda.getData());
        vendaDTO.setTotal(venda.getTotal());
        return vendaDTO;
    }
}
