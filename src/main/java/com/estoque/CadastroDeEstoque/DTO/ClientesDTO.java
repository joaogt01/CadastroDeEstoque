package com.estoque.CadastroDeEstoque.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDTO {

    private Long id;

    private String nome;

    private String email;

    private String telefone;
}
