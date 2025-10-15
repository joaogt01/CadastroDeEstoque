package com.estoque.CadastroDeEstoque.Controller;

import com.estoque.CadastroDeEstoque.Model.*;
import com.estoque.CadastroDeEstoque.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TabelaController {

    private final ClientesRepository clientesRepository;
    private final EstoqueRepository estoqueRepository;
    private final ProdutosRepository produtosRepository;
    private final UserRepository userRepository;
    private final VendasRepository vendaRepository;

    @GetMapping("/clientes")
    public String listarClientes(Model model){
        List<Clientes> clientes = clientesRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/estoque")
    public String listarEstoque(Model model){
        List<Estoque> estoques = estoqueRepository.findAll();
        model.addAttribute("estoques", estoques);
        return "estoque";
    }

    @GetMapping("/produtos")
    public String listarProdutos(Model model){
        List<ProdutosModel> produtos = produtosRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model){
        List<User> usuarios = userRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/venda")
    public String listarVendas(Model model){
        List<Venda> vendas = vendaRepository.findAll();
        model.addAttribute("vendas", vendas);
        return "venda";
    }
}
