package com.estoque.CadastroDeEstoque.Service;

import com.estoque.CadastroDeEstoque.DTO.EstoqueDTO;
import com.estoque.CadastroDeEstoque.Mapper.EstoqueMapper;
import com.estoque.CadastroDeEstoque.Model.Estoque;
import com.estoque.CadastroDeEstoque.Repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final EstoqueMapper estoqueMapper;

    public EstoqueService(EstoqueMapper estoqueMapper, EstoqueRepository estoqueRepository) {
        this.estoqueMapper = estoqueMapper;
        this.estoqueRepository = estoqueRepository;
    }

    public List<EstoqueDTO> listarEstoque(){
        List <Estoque> estoque = estoqueRepository.findAll();
        return estoque.stream()
                .map(estoqueMapper::map)
                .collect(Collectors.toList());

    }

    public EstoqueDTO listarEstoquePorId(Long id){
        Optional<Estoque> estoquePorId = estoqueRepository.findById(id);
        return estoquePorId.map(estoqueMapper::map).orElse(null);
    }

    public EstoqueDTO criarNoEstoque(EstoqueDTO estoqueDTO){
        Estoque estoque = estoqueMapper.map(estoqueDTO);
        estoque = estoqueRepository.save(estoque);
        return estoqueMapper.map(estoque);
    }

    public void deletarEstoquePorId(Long id){
        estoqueRepository.deleteById(id);
    }

    public EstoqueDTO atualizarEstoque(Long id, EstoqueDTO estoqueDTO){
        Optional<Estoque> estoqueExistente = estoqueRepository.findById(id);
        if (estoqueExistente.isPresent()){
            Estoque estoqueAtualizado = estoqueMapper.map(estoqueDTO);
            estoqueAtualizado.setId(id);
            Estoque estoqueSalvo = estoqueRepository.save(estoqueAtualizado);
            return estoqueMapper.map(estoqueSalvo);
        }
        return null;
    }
}
