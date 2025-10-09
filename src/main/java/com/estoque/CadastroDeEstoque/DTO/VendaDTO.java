package com.estoque.CadastroDeEstoque.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO {
    private Long id;

    private LocalDate data;

    private Double total;

}
