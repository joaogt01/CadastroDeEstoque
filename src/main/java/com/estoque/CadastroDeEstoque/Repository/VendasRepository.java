package com.estoque.CadastroDeEstoque.Repository;

import com.estoque.CadastroDeEstoque.Model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<Venda, Long> {
}
