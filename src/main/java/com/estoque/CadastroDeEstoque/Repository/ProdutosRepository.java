package com.estoque.CadastroDeEstoque.Repository;

import com.estoque.CadastroDeEstoque.Model.ProdutosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
}
