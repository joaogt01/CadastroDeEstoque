package com.estoque.CadastroDeEstoque.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String telefone;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    private List<Venda> vendas;
}
