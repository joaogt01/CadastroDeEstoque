package com.estoque.CadastroDeEstoque.Model;


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
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private float preco;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

}
