package com.estoque.CadastroDeEstoque.Mapper;

import com.estoque.CadastroDeEstoque.DTO.VendaDTO;
import com.estoque.CadastroDeEstoque.Model.Clientes;
import com.estoque.CadastroDeEstoque.Model.ProdutosModel;
import com.estoque.CadastroDeEstoque.Model.Venda;
import com.estoque.CadastroDeEstoque.Repository.ClientesRepository;
import com.estoque.CadastroDeEstoque.Repository.ProdutosRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VendaMapper {

    private final ClientesRepository clientesRepository;
    private final ProdutosRepository produtosRepository;

    public VendaMapper(ClientesRepository clientesRepository, ProdutosRepository produtosRepository){
        this.clientesRepository = clientesRepository;
        this.produtosRepository = produtosRepository;
    }

    public Venda map(VendaDTO vendaDTO){
        Venda venda = new Venda();
        venda.setId(vendaDTO.getId());
        venda.setData(vendaDTO.getData());
        if (vendaDTO.getClienteId() != null) {
            Clientes cliente = clientesRepository.findById(vendaDTO.getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            venda.setClientes(cliente);
        }

        if (vendaDTO.getProdutosIds() != null) {
            List<ProdutosModel> produtos = vendaDTO.getProdutosIds().stream()
                    .map(id -> produtosRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + id)))
                    .collect(Collectors.toList());
            venda.setProdutosModels(produtos);
        }

        venda.calcularTotal();
        return venda;
    }

    public VendaDTO map(Venda venda){
        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setId(venda.getId());
        vendaDTO.setData(venda.getData());
        vendaDTO.setTotal(venda.getTotal());
        if (venda.getClientes() != null) {
            vendaDTO.setClienteId(venda.getClientes().getId());
        }
        if (venda.getProdutosModels() != null) {
            vendaDTO.setProdutosIds(venda.getProdutosModels().stream()
                    .map(ProdutosModel::getId)
                    .collect(Collectors.toList()));
        }
        return vendaDTO;
    }
}
