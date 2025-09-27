package com.estoque.CadastroDeEstoque.Controller;

import com.estoque.CadastroDeEstoque.DTO.LoginRequest;
import com.estoque.CadastroDeEstoque.DTO.LoginResponse;
import com.estoque.CadastroDeEstoque.DTO.UserRequest;
import com.estoque.CadastroDeEstoque.DTO.UserResponse;
import com.estoque.CadastroDeEstoque.Mapper.UserMapper;
import com.estoque.CadastroDeEstoque.Model.User;
import com.estoque.CadastroDeEstoque.Service.TokenService;
import com.estoque.CadastroDeEstoque.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos/autenticacao")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/registrar")
    public ResponseEntity<UserResponse> registrar(@RequestBody UserRequest request) {
        User salvarUsuario = userService.save(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserMapper.toUserResponse(salvarUsuario));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.usuario(), request.senha());
        Authentication authenticate = authenticationManager.authenticate(userAndPass);

        User user = (User) authenticate.getPrincipal();

        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
