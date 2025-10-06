package com.estoque.CadastroDeEstoque.Configuracoes;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String nome, String usuario) {
}
