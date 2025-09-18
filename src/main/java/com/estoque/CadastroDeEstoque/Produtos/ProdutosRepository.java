package com.estoque.CadastroDeEstoque.Produtos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
}
