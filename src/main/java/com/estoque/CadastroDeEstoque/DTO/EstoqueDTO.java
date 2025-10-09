package com.estoque.CadastroDeEstoque.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {
    private Long id;

    private String localizacao;
}
