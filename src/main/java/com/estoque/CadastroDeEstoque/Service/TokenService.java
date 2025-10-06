package com.estoque.CadastroDeEstoque.Service;

import com.auth0.jwt.algorithms.Algorithm;
import com.estoque.CadastroDeEstoque.Model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;

import java.time.Instant;


@Component
public class TokenService {
    @Value("${CadastroDeEstoque.security.secret}")
    private String secret;


    public String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(user.getUsuario())
                .withClaim("userId", user.getId())
                .withClaim("name", user.getNome())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API Cadastro de estoque")
                .sign(algorithm);

    }

}
