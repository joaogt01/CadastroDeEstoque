package com.estoque.CadastroDeEstoque.DTO;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String nome, String usuario) {
}
