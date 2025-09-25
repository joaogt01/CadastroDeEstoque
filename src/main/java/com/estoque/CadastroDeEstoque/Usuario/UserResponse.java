package com.estoque.CadastroDeEstoque.Usuario;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String nome, String usuario) {
}
