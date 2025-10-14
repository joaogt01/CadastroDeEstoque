package com.estoque.CadastroDeEstoque.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutosDTO {

    private Long id;

    private String nome;

    private BigDecimal preco;

    private int quantidade;

    private Long estoqueId;
}
