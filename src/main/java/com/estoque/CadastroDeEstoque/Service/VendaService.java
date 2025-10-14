package com.estoque.CadastroDeEstoque.Service;

import com.estoque.CadastroDeEstoque.DTO.VendaDTO;
import com.estoque.CadastroDeEstoque.Mapper.VendaMapper;
import com.estoque.CadastroDeEstoque.Model.Venda;
import com.estoque.CadastroDeEstoque.Repository.VendasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendaService {
    private final VendasRepository vendasRepository;
    private final VendaMapper vendaMapper;

    public VendaService(VendaMapper vendaMapper, VendasRepository vendasRepository) {
        this.vendaMapper = vendaMapper;
        this.vendasRepository = vendasRepository;
    }

    public List<VendaDTO> listarVendas(){
        List<Venda> vendas = vendasRepository.findAll();
        return vendas.stream()
                .map(vendaMapper::map)
                .collect(Collectors.toList());
    }

    public VendaDTO listarVendaPorId(Long id){
        Optional<Venda> vendaPorId = vendasRepository.findById(id);
        return vendaPorId.map(vendaMapper::map).orElse(null);
    }

    public VendaDTO criarVenda(VendaDTO vendaDTO){
        Venda venda = vendaMapper.map(vendaDTO);
        venda = vendasRepository.save(venda);
        return vendaMapper.map(venda);
    }

    public void deletarVendaPorId(Long id){
        vendasRepository.deleteById(id);
    }

    public VendaDTO atualizarVenda(Long id, VendaDTO vendaDTO){
        Optional<Venda> vendaExistente = vendasRepository.findById(id);
        if (vendaExistente.isPresent()){
            Venda vendaAtualizada = vendaMapper.map(vendaDTO);
            vendaAtualizada.setId(id);
            Venda vendaSalva = vendasRepository.save(vendaAtualizada);
            return vendaMapper.map(vendaSalva);
        }
        return null;
    }
}
