package com.estoque.CadastroDeEstoque.Repository;

import com.estoque.CadastroDeEstoque.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<UserDetails> findByUsuario(String usuario);
}
