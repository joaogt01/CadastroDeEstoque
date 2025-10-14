package com.estoque.CadastroDeEstoque.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO {
    private Long id;

    private LocalDate data;

    private Double total;

    private Long clienteId;

    private List<Long> produtosIds;
}
