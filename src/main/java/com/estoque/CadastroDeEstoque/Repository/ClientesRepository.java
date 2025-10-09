package com.estoque.CadastroDeEstoque.Repository;

import com.estoque.CadastroDeEstoque.Model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
