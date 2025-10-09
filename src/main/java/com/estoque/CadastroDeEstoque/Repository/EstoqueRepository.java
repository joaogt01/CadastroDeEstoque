package com.estoque.CadastroDeEstoque.Repository;

import com.estoque.CadastroDeEstoque.Model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
