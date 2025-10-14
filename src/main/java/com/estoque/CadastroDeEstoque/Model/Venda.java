package com.estoque.CadastroDeEstoque.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Venda")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "Clientes_id")
    private Clientes clientes;

    @ManyToMany
    @JoinTable(
            name = "venda_produto",
            joinColumns = @JoinColumn(name = "Venda_id"),
            inverseJoinColumns = @JoinColumn(name = "tb_cadastro_produtos_id")
    )

    private List<ProdutosModel> produtosModels;

    @PrePersist
    public void prePersist() {
        this.data = LocalDate.now();
        calcularTotal();
    }

    public void calcularTotal(){
        if (produtosModels != null) {
            this.total = produtosModels.stream()
                    .mapToDouble(ProdutosModel::getPreco)
                    .sum();
        } else {
            this.total = 0.0;
        }
    }

}
