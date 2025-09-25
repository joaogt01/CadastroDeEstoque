package com.estoque.CadastroDeEstoque.Usuario;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User save(User user){
        String senha = user.getSenha();
        user.setSenha(passwordEncoder.encode(senha));
        return userRepository.save(user);
    }

}
