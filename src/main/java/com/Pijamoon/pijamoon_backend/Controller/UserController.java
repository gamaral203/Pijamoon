package com.Pijamoon.pijamoon_backend.Controller;

import com.Pijamoon.pijamoon_backend.Service.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private List<User> usuarios = new ArrayList<>(); // Armazena usuários temporariamente em memória

    // --- CADASTRAR USUÁRIO (via POST,) ---
    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestParam String nome, @RequestParam String email) {
        User novoUsuario = new User(nome, email);
        usuarios.add(novoUsuario);
        return "Usuário " + nome + " cadastrado com sucesso (via POST)!";
    }

    // --- CADASTRAR USUÁRIO (via GET, só para testes no navegador) ---
    @GetMapping("/cadastrar")
    public String cadastrarUsuarioGet(@RequestParam String nome, @RequestParam String email) {
        User novoUsuario = new User(nome, email);
        usuarios.add(novoUsuario);
        return "Usuário " + nome + " cadastrado com sucesso !";
    }

    // --- LISTAR TODOS OS USUÁRIOS CADASTRADOS ---
    @GetMapping("/listar")
    public List<User> listarUsuarios() {
        return usuarios;
    }
}
