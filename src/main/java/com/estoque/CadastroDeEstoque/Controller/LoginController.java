package com.estoque.CadastroDeEstoque.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String PaginaLogin(){
        return "login";
    }

    @GetMapping("/registrar")
    public String Cadastro(){
        return "cadastro";
    }
}
