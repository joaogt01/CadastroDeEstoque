package com.estoque.CadastroDeEstoque.Service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.estoque.CadastroDeEstoque.Model.User;
import com.estoque.CadastroDeEstoque.Repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Deve Salvar o usuario")
    void testSaveUser() {
        User user = new User();
        user.setSenha("senha123");

        String senhaCodificada = "senhaCodificada123";
        when(passwordEncoder.encode(user.getSenha())).thenReturn(senhaCodificada);
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User savedUser = userService.save(user);

        assertNotNull(savedUser);
        assertEquals(senhaCodificada, savedUser.getSenha());

        verify(passwordEncoder, times(1)).encode("senha123");
        verify(userRepository, times(1)).save(savedUser);
    }
}
