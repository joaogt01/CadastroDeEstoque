package com.estoque.CadastroDeEstoque.Service;

import com.estoque.CadastroDeEstoque.DTO.ProdutosDTO;
import com.estoque.CadastroDeEstoque.Mapper.ProdutosMapper;
import com.estoque.CadastroDeEstoque.Model.ProdutosModel;
import com.estoque.CadastroDeEstoque.Repository.ProdutosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;
    private final ProdutosMapper produtosMapper;

    public ProdutosService(ProdutosMapper produtosMapper, ProdutosRepository produtosRepository) {
        this.produtosMapper = produtosMapper;
        this.produtosRepository = produtosRepository;
    }

    //Listar todos os produtos
    public List<ProdutosDTO> listarProdutos(){
        List<ProdutosModel> produtos = produtosRepository.findAll();
        return produtos.stream()
                .map(produtosMapper::map)
                .collect(Collectors.toList());
    }

    //Listar produtos por ID
    public ProdutosDTO listarProdutosPorId(Long id){
        Optional<ProdutosModel> produtosPorId = produtosRepository.findById(id);
        return produtosRepository.findById(id)
                .map(produtosMapper::map)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

    }

    //Criar novo produto
    public ProdutosDTO criarProduto(ProdutosDTO produtosDTO){
        ProdutosModel produto = produtosMapper.map(produtosDTO);
        produto = produtosRepository.save(produto);
        return produtosMapper.map(produto);
    }

    //Deletar Produto
    public void deletarProdutoPorId(Long id){
        produtosRepository.deleteById(id);
    }

    //Atualizar Produto
    public ProdutosDTO atualizarProduto(Long id, ProdutosDTO produtosDTO){
        Optional<ProdutosModel> produtoExistente = produtosRepository.findById(id);
        if (produtoExistente.isPresent()){
            ProdutosModel produtoAtualizado = produtosMapper.map(produtosDTO);
            produtoAtualizado.setId(id);
            ProdutosModel produtoSalvo = produtosRepository.save(produtoAtualizado);
            return produtosMapper.map(produtoSalvo);

        }
        return null;
    }
}
