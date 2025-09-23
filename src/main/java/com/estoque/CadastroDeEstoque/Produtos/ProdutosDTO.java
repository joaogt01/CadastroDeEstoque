package com.estoque.CadastroDeEstoque.Produtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutosDTO {

    private Long id;

    private String nome;

    private float preco;

    private int quantidade;

}
