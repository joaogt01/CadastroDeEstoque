package com.estoque.CadastroDeEstoque.Produtos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro_produtos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private float preco;
    private int quantidade;
}
