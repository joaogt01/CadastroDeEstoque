package com.estoque.CadastroDeEstoque.Repository;

import com.estoque.CadastroDeEstoque.DTO.UserRequest;
import com.estoque.CadastroDeEstoque.DTO.UserResponse;
import com.estoque.CadastroDeEstoque.Model.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Deve obter o usuario do banco de dados")
    void findByUsuarioSuccess() {
        String usuario = "1";
        UserRequest userRequest = new UserRequest("João", usuario, "1234");
        this.criarUsuario(userRequest);

        Optional<UserDetails> usuarioCriado = this.userRepository.findByUsuario(usuario);

        assertThat(usuarioCriado.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Não deve obter o usuario do banco de dados quando o usuario nao existir")
    void findByUsuarioFail() {
        String usuario = "1";

        Optional<UserDetails> usuarioCriado = this.userRepository.findByUsuario(usuario);

        assertThat(usuarioCriado.isEmpty()).isTrue();
    }

    private User criarUsuario(UserRequest userRequest){
        User novoUsuario = new User(userRequest);
        this.entityManager.persist(novoUsuario);
        return novoUsuario;
    }
}